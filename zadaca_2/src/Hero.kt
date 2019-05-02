abstract class Hero(
    protected val name: String,
    protected var health: Int,
    protected val attack_damage: Int,
    protected var armor: Int,
    private val healing_factor: Int
)
{
    abstract fun attack(enemy: Enemy)
    abstract fun specialAttack(enemy: Enemy)
    abstract fun upgradeArmor()

    fun takeAHit(damage: Int)
    {
        val totalDamage = damage - (damage * armor / 100)
        health -= totalDamage
        if(health > 0)
        println("$name took a hit, health at $health%\n")
    }

    fun heal()
    {
        if(health < 100)
        {
         health = when(health)
         {
             in 0..(100 - healing_factor) -> health + healing_factor
             else -> 100
         }
            println("Healing...health now at $health")
        }
        else println("Health is full")
    }

    fun isDead():Boolean{
        return health <= 0
    }
}