import java.lang.Exception

fun main()
{
    val heroes= listOf(Wizard(),Archer(),Knight())

    val basilisk=Basilisk()
    val dragon=Dragon()
    val kraken=Kraken()

    var rand:Int

    println("Hello!\nWrite your name: ")
    val userName = readLine()
    println("Hello $userName!")

    val heroNumber=pick(1)

    var level=1

    println("******** LEVEL ONE ********")
    println("A basilisk appears before you, $userName...\n")

    while(level<4)
    {
        if(heroes[heroNumber-1].isDead())
        {
            println("You're dead! Game over.")
            break
        }

        val option=pick(3) //user picks the next action

        when(level)
        {
            1-> heroAction(option,heroNumber,basilisk,heroes)
            2-> heroAction(option,heroNumber,dragon,heroes)
            3-> heroAction(option,heroNumber,kraken,heroes)
        }
        if(option==5)
            break

        //checking if enemy's dead, if not - enemy attacks automatically
        when(level)
        {
            1->
            {
                if(basilisk.isDead())
                {
                    level++
                    println("******** LEVEL TWO ********")
                    println("This time you must fight a dragon, $userName...\n")
                }
                 else {
                    basilisk.attackOne(heroes[heroNumber-1])

                }
            }
            2->
            {
                if(dragon.isDead())
                {
                    level++
                    println("******** LEVEL THREE *********")
                    println("$userName, are you ready? The last enemy is the Kraken...\n")
                }
                else
                {
                    rand=(1..2).random()
                    if(rand==1)
                        dragon.attackOne(heroes[heroNumber-1])
                    else dragon.attackTwo(heroes[heroNumber-1])
                }
            }
            else ->
            {
                if(kraken.isDead())
                {
                    level++
                    println("Congrats, $userName.")
                    println("******** YOU WIN ********")
                }
                else
                {
                    rand=(1..3).random()
                    when(rand)
                    {
                        1->kraken.attackOne(heroes[heroNumber-1])
                        2->kraken.attackTwo(heroes[heroNumber-1])
                        else ->kraken.attackThree(heroes[heroNumber-1])
                    }
                }
            }
        }
    }
}

fun heroAction(option:Int, heroNumber:Int, enemy: Enemy, heroes:List<Hero>)
{
    when(heroNumber)
    {
        1->doTheAction(option,heroes[0],enemy)        // first hero    \
        2->doTheAction(option,heroes[1],enemy)        // second hero    |->  level depends on the enemy
        else->doTheAction(option,heroes[2],enemy)     // third hero    /
    }
}

fun doTheAction(option:Int,hero: Hero,enemy:Enemy)
{
    when(option)
    {
        1-> hero.attack(enemy)
        2->hero.specialAttack(enemy)
        3->hero.heal()
        4->hero.upgradeArmor()
        else-> println("You gave up. Game over!")
    }
}
fun pick(num: Int): Int
{
    val options = mapOf(
        1 to "Attack",
        2 to "Risky attack",
        3 to "Heal",
        4 to "Upgrade armor",
        5 to "Give up"
    )

    val heroNames= mapOf(1 to "Wizard",2 to "Archer", 3 to "Knight")

    var choice:IntRange=0..0
    var number=1
    var invalid=true
    while(choice==0..0)
    {
      choice = when(num)
      {
          1->1..3
          else->1..5
      }
        when(num)
        {
            1 -> {println("Pick your character(enter a number): $heroNames")}
            else -> println("Choose an action: $options")
        }
    }
    Start@
    while (invalid)
    {

        try
        {
            number= readLine()!!.toInt()
            if (number in choice)
                invalid = false
            else
            {
                println("Am I a joke to you? Pick a valid number!")
                continue@Start
            }
        }
        catch (e:NumberFormatException)
        {
            println("That's not a number, pal! Give it another go.")
        }
        catch (e: Exception)
        {
            println("Enter a valid number, please!")
        }
    }
    when(num)
    {
        1->println("You picked character number $number - The ${heroNames[number]}\n")
        else->println("You have chosen the option number $number - ${options.getValue(number)}\n")
    }
    return number
}

