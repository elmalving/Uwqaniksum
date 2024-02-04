namespace DBConstructor
{
    public partial class MainPage : Form
    {
        private bool adding = false;
        private bool changing = false;
        private string selectedItem;
        public MainPage()
        {
            InitializeComponent();
        }

        private void AddButton_Click(object sender, EventArgs e)
        {
            if (GlobalVariables.SelectedType == null)
            {
                return;
            }
            ClearPanel();
            adding = true;
            switch (GlobalVariables.ItemKind)
            {
                case "Weapon":
                    ShowPanel(weaponPanel);
                    break;
                case "Armor":
                    ShowPanel(armorPanel);
                    break;
                default:
                    ShowPanel(entityPanel);
                    break;
            }
        }
        private void ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ToolStripMenuItem clickedItem = (ToolStripMenuItem)sender;
            if (GlobalVariables.SelectedType != clickedItem.Text)
            {
                ClearPanel();
            }
            itemSelect.Text = GlobalVariables.SelectedType = clickedItem.Text;
            GlobalVariables.ItemKind = clickedItem.OwnerItem.Text;
            ReloadStripMenu();
        }
        private void ReloadStripMenu()
        {
            foreach (ListViewItem i in itemList.Items)
            {
                itemList.Items.Remove(i);
            }
            foreach (string itemName in SQLHandler.GetItemsName(GlobalVariables.SelectedType))
            {
                itemList.Items.Add(new ListViewItem(itemName));
            }
        }
        private static bool IsNumeric(string text)
        {
            if (double.TryParse(text, out _))
            {
                return true;
            }
            return false;
        }
        private void SaveButton_Click(object sender, EventArgs e)
        {
            if (adding)
            {
                switch (GlobalVariables.ItemKind)
                {
                    case "Weapon":
                        string damageValue = damageBox.Text.Replace('.', ',');
                        if (!IsNumeric(damageValue))
                        {
                            return;
                        }

                        Weapon weapon = new()
                        {
                            name = weaponNameBox.Text,
                            damage = double.Parse(damageValue)
                        };
                        SQLHandler.AddItem(weapon);
                        break;
                    case "Armor":
                        string armorValue = armorBox.Text.Replace('.', ',');
                        if (!IsNumeric(armorValue))
                        {
                            return;
                        }

                        Armor armor = new()
                        {
                            name = armorNameBox.Text,
                            armor = double.Parse(armorValue)
                        };
                        SQLHandler.AddItem(armor);
                        break;
                    default:
                        string healthValue = healthBox.Text.Replace('.', ',');
                        if (!IsNumeric(healthValue))
                        {
                            return;
                        }

                        Entity entity = new()
                        {
                            name = entityNameBox.Text,
                            health = double.Parse(healthValue)
                        };
                        SQLHandler.AddItem(entity);
                        break;
                }
                adding = false;
                MessageBox.Show("Successfully added!");
                ReloadStripMenu();
            }
            else if (changing)
            {
                int id = SQLHandler.GetItemId(selectedItem);
                switch (GlobalVariables.ItemKind)
                {
                    case "Weapon":
                        string damageValue = damageBox.Text.Replace('.', ',');
                        if (!IsNumeric(damageValue))
                        {
                            return;
                        }

                        Weapon weapon = new()
                        {
                            id = id,
                            name = weaponNameBox.Text,
                            damage = double.Parse(damageValue)
                        };
                        SQLHandler.ChangeItem(weapon);
                        break;
                    case "Armor":
                        string armorValue = armorBox.Text.Replace('.', ',');
                        if (!IsNumeric(armorValue))
                        {
                            return;
                        }

                        Armor armor = new()
                        {
                            id = id,
                            name = armorNameBox.Text,
                            armor = double.Parse(armorValue)
                        };
                        SQLHandler.ChangeItem(armor);
                        break;
                    default:
                        string healthValue = healthBox.Text.Replace('.', ',');
                        if (!IsNumeric(healthValue))
                        {
                            return;
                        }

                        Entity entity = new()
                        {
                            id = id,
                            name = entityNameBox.Text,
                            health = double.Parse(healthValue)
                        };
                        SQLHandler.ChangeItem(entity);
                        break;
                }
                changing = false;
                MessageBox.Show("Successfully changed!");
                ReloadStripMenu();
            }
            ClearPanel();
        }
        private void ClearPanel(object? sender = null, EventArgs? e = null)
        {
            adding = false;
            weaponPanel.Visible = false;
            armorPanel.Visible = false;
            entityPanel.Visible = false;
            weaponNameBox.Text = damageBox.Text = armorNameBox.Text = armorBox.Text =
                entityNameBox.Text = healthBox.Text = "";
        }

        private void ShowItemStats(object? sender = null, EventArgs? e = null)
        {
            SQLHandler handler = new();
            selectedItem = itemList.SelectedItems[0].Text;
            changing = true;
            switch (GlobalVariables.ItemKind)
            {
                case "Weapon":
                    Weapon weapon = (Weapon)handler.GetItem(selectedItem);
                    weaponNameBox.Text = weapon.name;
                    damageBox.Text = weapon.damage.ToString();
                    ShowPanel(weaponPanel);
                    break;
                case "Armor":
                    Armor armor = (Armor)handler.GetItem(selectedItem);
                    armorNameBox.Text = armor.name;
                    armorBox.Text = armor.armor.ToString();
                    ShowPanel(armorPanel);
                    break;
                case "Entity":
                    Entity entity = (Entity)handler.GetItem(selectedItem);
                    entityNameBox.Text = entity.name;
                    healthBox.Text = entity.health.ToString();
                    ShowPanel(entityPanel);
                    break;
            }
        }
        private void ShowPanel(Panel panel)
        {
            panel.Visible = true;
            Panel[] panels = [weaponPanel, armorPanel, entityPanel];
            foreach (Panel p in panels)
            {
                if (p != panel)
                {
                    p.Visible = false;
                }
            }
        }

        private void DeleteButton_Click(object sender, EventArgs e)
        {
            if (selectedItem == null)
            {
                return;
            }
            SQLHandler.DeleteItem(selectedItem);
            ClearPanel();
            ReloadStripMenu();
        }
    }
}
