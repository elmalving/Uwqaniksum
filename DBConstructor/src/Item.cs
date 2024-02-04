namespace DBConstructor
{
    public class Item
    {
        public int id;
        public required string name;
        public string? type;
    }
    public class Weapon : Item
    {
        public double damage;
    }
    public class Armor : Item
    {
        public double armor;
    }
    public class Entity : Item
    {
        public double health;
    }
}