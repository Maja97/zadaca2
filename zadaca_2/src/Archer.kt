class Archer(
    name: String = "Archer",
    health: Int = 100,
    attack_damage: Int = 20,
    armor: Int = 20,
    healingFactor: Int = 40
) : Hero(name, health, attack_damage, armor, healingFactor)
{
    override fun attack(enemy: Enemy)
    {
        val damage=attack_damage + (1..3).random() * 10
        println("$name attacks with $damage damage points")
        enemy.takeAHit(damage)
    }
    override fun specialAttack(enemy: Enemy) //if successful - steals health while attacking
    {
        when((1..100).random())
        {
            in 1..45 ->
            {
                val damage = attack_damage + (1..3).random() * 10
                enemy.takeAHit(damage)
                if(health + damage < 100)
                health += damage
                else health = 100
                println("Your risky attack was successful - you gained some health while attacking - health now at $health")
            }
            else -> println("Risky attack failed! Good luck next time!")
        }
    }
    override fun upgradeArmor()
    {
        if(armor < 100)
        {
            armor += 5
            println("Upgrading armor...now at $armor shield points")
        }
    }
}