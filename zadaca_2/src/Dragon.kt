class Dragon(
    name: String = "Dragon",
    health: Int = 100,
    attack_damage: Int = 40,
    armor: Int = 30
):Enemy(name, health, attack_damage, armor),LevelTwoAttacker
{
    override fun takeAHit(damage: Int)
    {
        val totalDamage = damage - (damage * armor / 105)
        health -= totalDamage
        if(health > 0)
            println("The $name takes a hit, health at $health%")
        else
            println("The $name is dead!\n")
    }
    override fun attackOne(hero: Hero)
    {
        val damage = attack_damage / 3
        hero.takeAHit(damage)
        println("The $name attacks with level one attack")
    }

    override fun attackTwo(hero: Hero)
    {
        val damage = (1..5).random() + attack_damage
        hero.takeAHit(damage)
        println("The $name attacks with level two attack")
    }
}