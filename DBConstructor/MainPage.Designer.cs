using System.Diagnostics;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace DBConstructor
{
    partial class MainPage
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menu = new MenuStrip();
            itemSelect = new ToolStripMenuItem();
            itemsToolStripMenuItem = new ToolStripMenuItem();
            armorToolStripMenuItem = new ToolStripMenuItem();
            helmetToolStripMenuItem = new ToolStripMenuItem();
            chestplateToolStripMenuItem = new ToolStripMenuItem();
            leggingsToolStripMenuItem = new ToolStripMenuItem();
            bootsToolStripMenuItem = new ToolStripMenuItem();
            weaponToolStripMenuItem = new ToolStripMenuItem();
            swordToolStripMenuItem = new ToolStripMenuItem();
            axeToolStripMenuItem = new ToolStripMenuItem();
            shovelToolStripMenuItem = new ToolStripMenuItem();
            stickToolStripMenuItem = new ToolStripMenuItem();
            entityToolStripMenuItem = new ToolStripMenuItem();
            zombieToolStripMenuItem = new ToolStripMenuItem();
            skeletonToolStripMenuItem = new ToolStripMenuItem();
            chickenToolStripMenuItem = new ToolStripMenuItem();
            golemToolStripMenuItem = new ToolStripMenuItem();
            itemList = new System.Windows.Forms.ListView();
            addButton = new System.Windows.Forms.Button();
            weaponPanel = new Panel();
            damageBox = new System.Windows.Forms.TextBox();
            damageLabel = new Label();
            weaponNameLabel = new Label();
            weaponNameBox = new System.Windows.Forms.TextBox();
            armorPanel = new Panel();
            armorBox = new System.Windows.Forms.TextBox();
            armorLabel = new Label();
            armorNameLabel = new Label();
            armorNameBox = new System.Windows.Forms.TextBox();
            entityPanel = new Panel();
            healthBox = new System.Windows.Forms.TextBox();
            healthLabel = new Label();
            entityNameLabel = new Label();
            entityNameBox = new System.Windows.Forms.TextBox();
            saveButton = new System.Windows.Forms.Button();
            cancelButton = new System.Windows.Forms.Button();
            deleteButton = new System.Windows.Forms.Button();
            menu.SuspendLayout();
            weaponPanel.SuspendLayout();
            armorPanel.SuspendLayout();
            entityPanel.SuspendLayout();
            SuspendLayout();
            // 
            // menu
            // 
            menu.AutoSize = false;
            menu.BackColor = SystemColors.ActiveBorder;
            menu.Dock = DockStyle.None;
            menu.Items.AddRange(new ToolStripItem[] { itemSelect });
            menu.LayoutStyle = ToolStripLayoutStyle.VerticalStackWithOverflow;
            menu.Location = new Point(9, 9);
            menu.Name = "menu";
            menu.Padding = new Padding(0);
            menu.Size = new Size(206, 70);
            menu.TabIndex = 0;
            menu.Text = "menuStrip1";
            // 
            // itemSelect
            // 
            itemSelect.AutoSize = false;
            itemSelect.BackColor = SystemColors.ButtonFace;
            itemSelect.DropDownItems.AddRange(new ToolStripItem[] { itemsToolStripMenuItem, entityToolStripMenuItem });
            itemSelect.Margin = new Padding(0, 10, 0, 0);
            itemSelect.Name = "itemSelect";
            itemSelect.Padding = new Padding(0);
            itemSelect.Size = new Size(175, 50);
            itemSelect.Text = "Select type";
            // 
            // itemsToolStripMenuItem
            // 
            itemsToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { armorToolStripMenuItem, weaponToolStripMenuItem });
            itemsToolStripMenuItem.Name = "itemsToolStripMenuItem";
            itemsToolStripMenuItem.Size = new Size(104, 22);
            itemsToolStripMenuItem.Text = "Items";
            // 
            // armorToolStripMenuItem
            // 
            armorToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { helmetToolStripMenuItem, chestplateToolStripMenuItem, leggingsToolStripMenuItem, bootsToolStripMenuItem });
            armorToolStripMenuItem.Name = "armorToolStripMenuItem";
            armorToolStripMenuItem.Size = new Size(118, 22);
            armorToolStripMenuItem.Text = "Armor";
            // 
            // helmetToolStripMenuItem
            // 
            helmetToolStripMenuItem.Name = "helmetToolStripMenuItem";
            helmetToolStripMenuItem.Size = new Size(130, 22);
            helmetToolStripMenuItem.Text = "Helmet";
            helmetToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // chestplateToolStripMenuItem
            // 
            chestplateToolStripMenuItem.Name = "chestplateToolStripMenuItem";
            chestplateToolStripMenuItem.Size = new Size(130, 22);
            chestplateToolStripMenuItem.Text = "Chestplate";
            chestplateToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // leggingsToolStripMenuItem
            // 
            leggingsToolStripMenuItem.Name = "leggingsToolStripMenuItem";
            leggingsToolStripMenuItem.Size = new Size(130, 22);
            leggingsToolStripMenuItem.Text = "Leggings";
            leggingsToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // bootsToolStripMenuItem
            // 
            bootsToolStripMenuItem.Name = "bootsToolStripMenuItem";
            bootsToolStripMenuItem.Size = new Size(130, 22);
            bootsToolStripMenuItem.Text = "Boots";
            bootsToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // weaponToolStripMenuItem
            // 
            weaponToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { swordToolStripMenuItem, axeToolStripMenuItem, shovelToolStripMenuItem, stickToolStripMenuItem });
            weaponToolStripMenuItem.Name = "weaponToolStripMenuItem";
            weaponToolStripMenuItem.Size = new Size(118, 22);
            weaponToolStripMenuItem.Text = "Weapon";
            // 
            // swordToolStripMenuItem
            // 
            swordToolStripMenuItem.Name = "swordToolStripMenuItem";
            swordToolStripMenuItem.Size = new Size(109, 22);
            swordToolStripMenuItem.Text = "Sword";
            swordToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // axeToolStripMenuItem
            // 
            axeToolStripMenuItem.Name = "axeToolStripMenuItem";
            axeToolStripMenuItem.Size = new Size(109, 22);
            axeToolStripMenuItem.Text = "Axe";
            axeToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // shovelToolStripMenuItem
            // 
            shovelToolStripMenuItem.Name = "shovelToolStripMenuItem";
            shovelToolStripMenuItem.Size = new Size(109, 22);
            shovelToolStripMenuItem.Text = "Shovel";
            shovelToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // stickToolStripMenuItem
            // 
            stickToolStripMenuItem.Name = "stickToolStripMenuItem";
            stickToolStripMenuItem.Size = new Size(109, 22);
            stickToolStripMenuItem.Text = "Stick";
            stickToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // entityToolStripMenuItem
            // 
            entityToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { zombieToolStripMenuItem, skeletonToolStripMenuItem, chickenToolStripMenuItem, golemToolStripMenuItem });
            entityToolStripMenuItem.Name = "entityToolStripMenuItem";
            entityToolStripMenuItem.Size = new Size(104, 22);
            entityToolStripMenuItem.Text = "Entity";
            // 
            // zombieToolStripMenuItem
            // 
            zombieToolStripMenuItem.Name = "zombieToolStripMenuItem";
            zombieToolStripMenuItem.Size = new Size(119, 22);
            zombieToolStripMenuItem.Text = "Zombie";
            zombieToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // skeletonToolStripMenuItem
            // 
            skeletonToolStripMenuItem.Name = "skeletonToolStripMenuItem";
            skeletonToolStripMenuItem.Size = new Size(119, 22);
            skeletonToolStripMenuItem.Text = "Skeleton";
            skeletonToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // chickenToolStripMenuItem
            // 
            chickenToolStripMenuItem.Name = "chickenToolStripMenuItem";
            chickenToolStripMenuItem.Size = new Size(119, 22);
            chickenToolStripMenuItem.Text = "Chicken";
            chickenToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // golemToolStripMenuItem
            // 
            golemToolStripMenuItem.Name = "golemToolStripMenuItem";
            golemToolStripMenuItem.Size = new Size(119, 22);
            golemToolStripMenuItem.Text = "Golem";
            golemToolStripMenuItem.Click += ToolStripMenuItem_Click;
            // 
            // itemList
            // 
            itemList.BackColor = SystemColors.ActiveBorder;
            itemList.BorderStyle = BorderStyle.None;
            itemList.Font = new Font("Segoe UI", 12F);
            itemList.ImeMode = ImeMode.NoControl;
            itemList.Location = new Point(9, 82);
            itemList.Margin = new Padding(0);
            itemList.Name = "itemList";
            itemList.Size = new Size(206, 309);
            itemList.TabIndex = 1;
            itemList.TileSize = new Size(185, 30);
            itemList.UseCompatibleStateImageBehavior = false;
            itemList.View = View.Tile;
            itemList.ItemActivate += ShowItemStats;
            // 
            // addButton
            // 
            addButton.Font = new Font("Segoe UI", 16F, FontStyle.Bold);
            addButton.Location = new Point(9, 397);
            addButton.Name = "addButton";
            addButton.Size = new Size(206, 41);
            addButton.TabIndex = 2;
            addButton.Text = "ADD";
            addButton.UseVisualStyleBackColor = true;
            addButton.Click += AddButton_Click;
            // 
            // weaponPanel
            // 
            weaponPanel.Controls.Add(damageBox);
            weaponPanel.Controls.Add(damageLabel);
            weaponPanel.Controls.Add(weaponNameLabel);
            weaponPanel.Controls.Add(weaponNameBox);
            weaponPanel.Location = new Point(218, 9);
            weaponPanel.Name = "weaponPanel";
            weaponPanel.Size = new Size(570, 382);
            weaponPanel.TabIndex = 3;
            weaponPanel.Visible = false;
            // 
            // damageBox
            // 
            damageBox.Location = new Point(40, 106);
            damageBox.Name = "damageBox";
            damageBox.Size = new Size(285, 23);
            damageBox.TabIndex = 5;
            // 
            // damageLabel
            // 
            damageLabel.AutoSize = true;
            damageLabel.Font = new Font("Segoe UI", 16F);
            damageLabel.Location = new Point(40, 73);
            damageLabel.Name = "damageLabel";
            damageLabel.Size = new Size(94, 30);
            damageLabel.TabIndex = 4;
            damageLabel.Text = "Damage";
            // 
            // weaponNameLabel
            // 
            weaponNameLabel.AutoSize = true;
            weaponNameLabel.Font = new Font("Segoe UI", 16F);
            weaponNameLabel.Location = new Point(40, 14);
            weaponNameLabel.Name = "weaponNameLabel";
            weaponNameLabel.Size = new Size(71, 30);
            weaponNameLabel.TabIndex = 1;
            weaponNameLabel.Text = "Name";
            // 
            // weaponNameBox
            // 
            weaponNameBox.Location = new Point(40, 47);
            weaponNameBox.Name = "weaponNameBox";
            weaponNameBox.Size = new Size(285, 23);
            weaponNameBox.TabIndex = 0;
            // 
            // armorPanel
            // 
            armorPanel.Controls.Add(armorBox);
            armorPanel.Controls.Add(armorLabel);
            armorPanel.Controls.Add(armorNameLabel);
            armorPanel.Controls.Add(armorNameBox);
            armorPanel.Location = new Point(218, 9);
            armorPanel.Name = "armorPanel";
            armorPanel.Size = new Size(570, 382);
            armorPanel.TabIndex = 6;
            armorPanel.Visible = false;
            // 
            // armorBox
            // 
            armorBox.Location = new Point(40, 106);
            armorBox.Name = "armorBox";
            armorBox.Size = new Size(285, 23);
            armorBox.TabIndex = 5;
            // 
            // armorLabel
            // 
            armorLabel.AutoSize = true;
            armorLabel.Font = new Font("Segoe UI", 16F);
            armorLabel.Location = new Point(40, 73);
            armorLabel.Name = "armorLabel";
            armorLabel.Size = new Size(75, 30);
            armorLabel.TabIndex = 4;
            armorLabel.Text = "Armor";
            // 
            // armorNameLabel
            // 
            armorNameLabel.AutoSize = true;
            armorNameLabel.Font = new Font("Segoe UI", 16F);
            armorNameLabel.Location = new Point(40, 14);
            armorNameLabel.Name = "armorNameLabel";
            armorNameLabel.Size = new Size(71, 30);
            armorNameLabel.TabIndex = 1;
            armorNameLabel.Text = "Name";
            // 
            // armorNameBox
            // 
            armorNameBox.Location = new Point(40, 47);
            armorNameBox.Name = "armorNameBox";
            armorNameBox.Size = new Size(285, 23);
            armorNameBox.TabIndex = 0;
            // 
            // entityPanel
            // 
            entityPanel.Controls.Add(healthBox);
            entityPanel.Controls.Add(healthLabel);
            entityPanel.Controls.Add(entityNameLabel);
            entityPanel.Controls.Add(entityNameBox);
            entityPanel.Location = new Point(218, 9);
            entityPanel.Name = "entityPanel";
            entityPanel.Size = new Size(570, 382);
            entityPanel.TabIndex = 6;
            entityPanel.Visible = false;
            // 
            // healthBox
            // 
            healthBox.Location = new Point(40, 106);
            healthBox.Name = "healthBox";
            healthBox.Size = new Size(285, 23);
            healthBox.TabIndex = 5;
            // 
            // healthLabel
            // 
            healthLabel.AutoSize = true;
            healthLabel.Font = new Font("Segoe UI", 16F);
            healthLabel.Location = new Point(40, 73);
            healthLabel.Name = "healthLabel";
            healthLabel.Size = new Size(76, 30);
            healthLabel.TabIndex = 4;
            healthLabel.Text = "Health";
            // 
            // entityNameLabel
            // 
            entityNameLabel.AutoSize = true;
            entityNameLabel.Font = new Font("Segoe UI", 16F);
            entityNameLabel.Location = new Point(40, 14);
            entityNameLabel.Name = "entityNameLabel";
            entityNameLabel.Size = new Size(71, 30);
            entityNameLabel.TabIndex = 1;
            entityNameLabel.Text = "Name";
            // 
            // entityNameBox
            // 
            entityNameBox.Location = new Point(40, 47);
            entityNameBox.Name = "entityNameBox";
            entityNameBox.Size = new Size(285, 23);
            entityNameBox.TabIndex = 0;
            // 
            // saveButton
            // 
            saveButton.Font = new Font("Segoe UI", 16F, FontStyle.Bold);
            saveButton.Location = new Point(450, 397);
            saveButton.Name = "saveButton";
            saveButton.Size = new Size(112, 41);
            saveButton.TabIndex = 4;
            saveButton.Text = "Save";
            saveButton.UseVisualStyleBackColor = true;
            saveButton.Click += SaveButton_Click;
            // 
            // cancelButton
            // 
            cancelButton.Font = new Font("Segoe UI", 16F);
            cancelButton.Location = new Point(681, 397);
            cancelButton.Name = "cancelButton";
            cancelButton.Size = new Size(107, 41);
            cancelButton.TabIndex = 5;
            cancelButton.Text = "Cancel";
            cancelButton.UseVisualStyleBackColor = true;
            cancelButton.Click += ClearPanel;
            // 
            // deleteButton
            // 
            deleteButton.Font = new Font("Segoe UI", 16F);
            deleteButton.Location = new Point(568, 397);
            deleteButton.Name = "deleteButton";
            deleteButton.Size = new Size(107, 41);
            deleteButton.TabIndex = 7;
            deleteButton.Text = "Delete";
            deleteButton.UseVisualStyleBackColor = true;
            deleteButton.Click += DeleteButton_Click;
            // 
            // MainPage
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(deleteButton);
            Controls.Add(armorPanel);
            Controls.Add(weaponPanel);
            Controls.Add(entityPanel);
            Controls.Add(addButton);
            Controls.Add(cancelButton);
            Controls.Add(saveButton);
            Controls.Add(itemList);
            Controls.Add(menu);
            MainMenuStrip = menu;
            Name = "MainPage";
            Text = "MainPage";
            menu.ResumeLayout(false);
            menu.PerformLayout();
            weaponPanel.ResumeLayout(false);
            weaponPanel.PerformLayout();
            armorPanel.ResumeLayout(false);
            armorPanel.PerformLayout();
            entityPanel.ResumeLayout(false);
            entityPanel.PerformLayout();
            ResumeLayout(false);
        }

        #endregion

        private MenuStrip menu;
        private ToolStripMenuItem itemSelect;
        private ToolStripMenuItem itemsToolStripMenuItem;
        private ToolStripMenuItem armorToolStripMenuItem;
        private ToolStripMenuItem helmetToolStripMenuItem;
        private ToolStripMenuItem chestplateToolStripMenuItem;
        private ToolStripMenuItem leggingsToolStripMenuItem;
        private ToolStripMenuItem bootsToolStripMenuItem;
        private ToolStripMenuItem weaponToolStripMenuItem;
        private ToolStripMenuItem swordToolStripMenuItem;
        private ToolStripMenuItem axeToolStripMenuItem;
        private ToolStripMenuItem shovelToolStripMenuItem;
        private ToolStripMenuItem stickToolStripMenuItem;
        private ToolStripMenuItem entityToolStripMenuItem;
        private ToolStripMenuItem zombieToolStripMenuItem;
        private ToolStripMenuItem skeletonToolStripMenuItem;
        private ToolStripMenuItem chickenToolStripMenuItem;
        private ToolStripMenuItem golemToolStripMenuItem;
        private System.Windows.Forms.ListView itemList;
        private System.Windows.Forms.Button addButton;
        private Panel weaponPanel;
        private System.Windows.Forms.TextBox weaponNameBox;
        private Label weaponNameLabel;
        private System.Windows.Forms.TextBox damageBox;
        private Label damageLabel;
        private Panel armorPanel;
        private System.Windows.Forms.TextBox armorBox;
        private Label armorLabel;
        private Label armorNameLabel;
        private System.Windows.Forms.TextBox armorNameBox;
        private Panel entityPanel;
        private System.Windows.Forms.TextBox healthBox;
        private Label healthLabel;
        private Label entityNameLabel;
        private System.Windows.Forms.TextBox entityNameBox;
        private System.Windows.Forms.Button saveButton;
        private System.Windows.Forms.Button cancelButton;
        private System.Windows.Forms.Button deleteButton;
    }
}