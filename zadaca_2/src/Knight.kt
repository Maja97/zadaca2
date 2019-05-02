class Knight(
    name: String="Knight",
    health: Int=100,
    attack_damage: Int=30,
    armor: Int=15,
    healingFactor: Int=30
):Hero(name, health, attack_damage, armor, healingFactor)
{

    override fun attack(enemy: Enemy)
    {
        val damage = attack_damage + (1..2).random() * 10
        println("$name attacks with $damage damage points")
        enemy.takeAHit(damage)
    }
    override fun specialAttack(enemy: Enemy)  // if successful - attack + armor upgrade
    {
        when ((1..100).random())
        {
            in 1..40 ->
            {
                val damage = attack_damage + (1..2).random() * 10 + 10
                println("You did a risky attack, and it payed off!")
                println("You attack the enemy with increased $damage points of damage and get an armor upgrade, all in one move!")
                upgradeArmor()
                enemy.takeAHit(damage)
            }
            else -> println("You did nothing! Good luck next time!")
        }
    }

    override fun upgradeArmor()
    {
        if(armor < 100)
        {
            armor += 7
            println("Upgrading armor...now at $armor shield points")
        }
    }

}
