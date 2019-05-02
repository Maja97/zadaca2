abstract class Enemy(
    protected var name: String,
    protected var health: Int,
    protected val attack_damage: Int,
    protected val armor: Int
)
{
    abstract fun takeAHit(damage: Int)

    fun isDead(): Boolean {
        return health <= 0
    }
}