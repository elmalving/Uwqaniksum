package egoniks.uwqaniksum.Quests;

import egoniks.uwqaniksum.Enemies.Enemy;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static egoniks.uwqaniksum.Enemies.Enemy.TESTENEMI;



public enum Quest {

    quest1("LoreQuest", new ArrayList<>(Arrays.asList(
            "Ты дебил",
            "Сории за скилл",
            "",
            "Вы можете взять этот квест"
    )), "lore"),
    quest2("FarmQuest", new ArrayList<>(Arrays.asList(
            "Убить TestMob",
            "",
            "TestMob 0/5",
            "",
            "Вы можете взять этот квест"
    )), "farm", getMapEnemyInteger(TESTENEMI, 5), 2, getMapEnemyInteger(TESTENEMI, 0), false),
    quest3("ItemQuest", new ArrayList<>(Arrays.asList(
            "Дать алмазы максимке",
            "",
            "Алмазы x1",
            "",
            "Вы можете взять этот квест"
    )), "item", new ArrayList<>(Arrays.asList(
            getItemStack(Material.DIAMOND, 1)
    )));
    String questTitle;
    List<String> questLore;
    String questType;
    Map<Enemy,Integer> questMobsAndHowMuchToKill;
    Map<Enemy,Integer> questMobsAndHowMuchKillYet;
    Integer strokes;//Убрать
    Integer questNumber;// добавить
    Boolean questIsEnable;
    List<ItemStack> questItems;
    Quest(String questTitle, List<String> questLore, String questType) {
        this.questTitle = questTitle;
        this.questLore = questLore;
        this.questType = questType;
    }

    Quest(String questTitle, List<String> questLore, String questType, Map<Enemy,Integer> questMobsAndHowMuchToKill, Integer strokes, Map<Enemy,Integer> questMobsAndHowMuchKillYet, boolean questIsEnable ) {
        this.questTitle = questTitle;
        this.questLore = questLore;
        this.questType = questType;
        this.questMobsAndHowMuchToKill = questMobsAndHowMuchToKill;
        this.strokes = strokes;
        this.questMobsAndHowMuchKillYet = questMobsAndHowMuchKillYet;
        this.questIsEnable = questIsEnable;
    }

    Quest(String questTitle, List<String> questLore, String questType,  List<ItemStack> questItems) {
        this.questTitle = questTitle;
        this.questLore = questLore;
        this.questType = questType;
        this.questItems = questItems;
    }

    public Boolean getQuestIsEnable() {
        return questIsEnable;
    }

    public void setQuestIsEnable(Boolean questIsEnable) {
        this.questIsEnable = questIsEnable;
    }

    public String getQuestTitle() {
        return questTitle;
    }

    public void setQuestTitle(String questTitle) {
        this.questTitle = questTitle;
    }

    public List<String> getQuestLore() {
        return questLore;
    }

    public void setQuestLore(List<String> questLore) {
        this.questLore = questLore;
    }

    public String getQuestType() {
        return questType;
    }

    public void setQuestType(String questType) {
        this.questType = questType;
    }


    public Integer getStrokes() {
        return strokes;
    }

    public void setStrokes(Integer strokes) {
        this.strokes = strokes;
    }

    public Map<Enemy, Integer> getQuestMobsAndHowMuchToKill() {
        return questMobsAndHowMuchToKill;
    }

    public void setQuestMobsAndHowMuchToKill(Map<Enemy, Integer> questMobsAndHowMuchToKill) {
        this.questMobsAndHowMuchToKill = questMobsAndHowMuchToKill;
    }

    public Map<Enemy, Integer> getQuestMobsAndHowMuchKillYet() {
        return questMobsAndHowMuchKillYet;
    }

    public void setQuestMobsAndHowMuchKillYet(Map<Enemy, Integer> questMobsAndHowMuchKillYet) {
        this.questMobsAndHowMuchKillYet = questMobsAndHowMuchKillYet;
    }

    public List<ItemStack> getQuestItems() {
        return questItems;
    }

    public void setQuestItems(List<ItemStack> questItems) {
        this.questItems = questItems;
    }

    public static Map<Enemy, Integer> getMapEnemyInteger(Enemy enemy, Integer amount){
        Map<Enemy,Integer> map = new HashMap<>();
        map.put(enemy,amount);
        return map;
    }
    public static ItemStack getItemStack(Material material, Integer amount){
        return new ItemStack(material, amount);
    }
}
