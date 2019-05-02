class Basilisk(
    name: String = "Basilisk",
    health: Int = 100,
    attack_damage: Int = 30,
    armor: Int = 10
):Enemy(name, health, attack_damage, armor),LevelOneAttacker
{
    override fun takeAHit(damage: Int)
    {
        val totalDamage = damage - (damage * armor / 100)
        health -= totalDamage
        if(health > 0)
            println("The $name takes a hit, health at $health%")
        else
            println("The $name is dead!\n")
    }

    override fun attackOne(hero: Hero)
    {
        val factor = (1..10).random()
        hero.takeAHit(attack_damage + factor)
    }
}