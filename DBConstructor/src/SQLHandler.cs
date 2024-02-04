using Microsoft.Data.Sqlite;

namespace DBConstructor
{
    public class SQLHandler
    {
        public static int GetItemId(string name)
        {
            string query = $"SELECT id FROM {GlobalVariables.ItemKind} WHERE name = @name;";

            using SqliteConnection conn = new("Data Source=../../../database.db");
            conn.Open();

            using SqliteCommand command = new SqliteCommand(query, conn);
            command.Parameters.AddWithValue("@name", name);

            using SqliteDataReader reader = command.ExecuteReader();
            reader.Read();

            return reader.GetInt32(0);
        }

        public static List<string> GetItemsName(string type)
        {
            List<string> items = [];
            string query = $"SELECT name FROM {GlobalVariables.ItemKind} WHERE type = @type;";

            using SqliteConnection conn = new SqliteConnection("Data Source=../../../database.db");
            conn.Open();

            using SqliteCommand command = new SqliteCommand(query, conn);
            command.Parameters.AddWithValue("@type", type);

            using SqliteDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                items.Add(reader.GetString(0));
            }

            return items;
        }

        public static void AddItem(Item item)
        {
            string mainStat = "damage";
            double mainStatValue = (item as Weapon)?.damage ?? 0;
            switch (GlobalVariables.ItemKind)
            {
                case "Armor":
                    mainStat = "armor";
                    mainStatValue = (item as Armor)?.armor ?? 0;
                    break;
                case "Entity":
                    mainStat = "health";
                    mainStatValue = (item as Entity)?.health ?? 0;
                    break;
            }
            string query = $"INSERT INTO {GlobalVariables.ItemKind}(name, type, {mainStat}) VALUES (@name, @type, @mainStatValue);";

            using SqliteConnection conn = new("Data Source=../../../database.db");
            conn.Open();

            using SqliteCommand command = new SqliteCommand(query, conn);
            command.Parameters.AddWithValue("@name", item.name);
            command.Parameters.AddWithValue("@type", GlobalVariables.SelectedType);
            command.Parameters.AddWithValue("@mainStatValue", mainStatValue);

            command.ExecuteNonQuery();
        }

        public static void ChangeItem(Item item)
        {
            string mainStat = "damage";
            double mainStatValue = (item as Weapon)?.damage ?? 0;
            switch (GlobalVariables.ItemKind)
            {
                case "Armor":
                    mainStat = "armor";
                    mainStatValue = (item as Armor)?.armor ?? 0;
                    break;
                case "Entity":
                    mainStat = "health";
                    mainStatValue = (item as Entity)?.health ?? 0;
                    break;
            }

            string query = $"UPDATE {GlobalVariables.ItemKind} SET name = @name, {mainStat} = @mainStatValue WHERE id = @id;";

            using SqliteConnection conn = new("Data Source=../../../database.db");
            conn.Open();

            using SqliteCommand command = new SqliteCommand(query, conn);
            command.Parameters.AddWithValue("@id", item.id);
            command.Parameters.AddWithValue("@name", item.name);
            command.Parameters.AddWithValue("@mainStatValue", mainStatValue);

            command.ExecuteNonQuery();
        }


        public static void DeleteItem(string name)
        {
            string query = $"DELETE FROM {GlobalVariables.ItemKind} WHERE name = @name;";

            using SqliteConnection conn = new("Data Source=../../../database.db");
            conn.Open();

            using SqliteCommand command = new SqliteCommand(query, conn);
            command.Parameters.AddWithValue("@name", name);

            command.ExecuteNonQuery();
        }

        public Item GetItem(string name)
        {
            string query = $"SELECT * FROM {GlobalVariables.ItemKind} WHERE name = @name;";

            using SqliteConnection conn = new SqliteConnection("Data Source=../../../database.db");
            conn.Open();

            using SqliteCommand command = new SqliteCommand(query, conn);
            command.Parameters.AddWithValue("@name", name);

            using SqliteDataReader reader = command.ExecuteReader();
            reader.Read();
            return GlobalVariables.ItemKind switch
            {
                "Weapon" => CreateWeapon(reader),
                "Armor" => CreateArmor(reader),
                "Entity" => CreateEntity(reader)
            };
        }


        private Weapon CreateWeapon(SqliteDataReader reader)
        {
            return new Weapon
            {
                id = reader.GetInt32(0),
                name = reader.GetString(1),
                damage = reader.GetDouble(3)
            };
        }
        private Armor CreateArmor(SqliteDataReader reader)
        {
            return new Armor
            {
                id = reader.GetInt32(0),
                name = reader.GetString(1),
                armor = reader.GetDouble(3)
            };
        }
        private Entity CreateEntity(SqliteDataReader reader)
        {
            return new Entity
            {
                id = reader.GetInt32(0),
                name = reader.GetString(1),
                health = reader.GetDouble(3)
            };
        }
    }
}