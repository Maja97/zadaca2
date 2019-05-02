class Wizard(
    name: String = "Wizard",
    health: Int = 100,
    attack_damage: Int = 10,
    armor: Int = 25,
    healingFactor: Int = 50
):Hero(name, health, attack_damage, armor, healingFactor)
{
    override fun attack(enemy:Enemy)
    {
        val damage = attack_damage*(2..5).random()
        println("$name attacks with $damage damage points")
        enemy.takeAHit(damage)
    }
    override fun specialAttack(enemy: Enemy) //if successful - doubles the usual damage
    {
        when((1..100).random())
        {
            in 1..50 ->
            {
                val damage=2*attack_damage*(2..5).random()
                println("You did a risky attack, and it payed off!")
                println("$name attacked with a damage of $damage")
                enemy.takeAHit(damage)
            }
            else-> println("You did nothing! Good luck next time!")
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