class Kraken(
    name: String = "Kraken",
    health: Int = 100,
    attack_damage: Int = 50,
    armor: Int = 60
) :Enemy(name, health, attack_damage, armor),LevelThreeAttacker
{
    override fun takeAHit(damage: Int)
    {
        val totalDamage = damage - (damage * armor / 115)
        health -= totalDamage
        if(health > 0)
            println("The $name has taken a hit, health at $health%")
        else
            println("The $name is dead!\n")
    }

    override fun attackOne(hero: Hero)
    {
        val damage = attack_damage / 4
        hero.takeAHit(damage)
        println("The $name attacks with level one attack")
    }

    override fun attackTwo(hero: Hero)
    {
        val damage = (2..4).random()+attack_damage
        hero.takeAHit(damage)
        println("The $name attacks with level two attack")
    }

    override fun attackThree(hero: Hero)
    {
        hero.takeAHit(attack_damage + 10)
        println("The $name attacks with level three attack")
    }
}