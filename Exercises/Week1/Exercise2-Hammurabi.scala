/**
  * Created by Serkan on 14/01/2017.
  */


import scala.util.Random

object Hammurabi {

  def main(args: Array[String]): Unit = {
    println("Welcome to Hammurabi's world")


    /*................................................................................*/

    //program begins with the following into message
    def printIntroMessage() =
    {

      println ( """
Congratulations, you are the newest ruler of ancient Samaria, elected
for a ten year term of office. Your duties are to dispense food, direct
farming, and buy and sell land as needed to support your people. Watch
out for rat infestations and the plague! Grain is the general currency,
measured in bushels. The following will help you in your decisions:
  * Each person needs at least 20 bushels of grain per year to survive.
  * Each person can farm at most 10 acres of land.
  * It takes 2 bushels of grain to farm an acre of land.
  * The market price for land fluctuates yearly.
 Rule wisely and you will be showered with appreciation at the end of
 your term. Rule poorly and you will be kicked out of office!""")
    }


    /*................................................................................*/



    def hammurabi () =
    {
      var starved = 0   // how many people starved
      var immigrants = 5 // how many people came to the city
      var population = 100
      var harvest = 3000   // total bushels harvested
      var bushelsPerAcre = 3   // amount harvested for each acre planted
      var rats_ate = 200   // bushels destroyed by rats
      var bushelsInStorage = 2800
      var acresOwned = 1000
      var pricePerAcre = 19 // each acre costs this many bushels
      var plagueDeaths = 0


      //call to this AFTER the declaration of the above variables
      printIntroMessage()




      //Error handling if user doesn't enter an integer
      def readInt(message: String): Int =
      {
        try
        {
          readLine(message).toInt
        }
        catch
          {
            case _ : Throwable =>
              println("That’s not an integer. Please enter an integer.")
              readInt(message)
          }
      }



      //year on year loop

      var year = 1
      while ( year != 10 )
      {

        // At the beginning of each year, you great Hammurabi is asked the following questions:

        def askHowMuchLandToBuy(bushels: Int, price: Int) =
        {
          var acresToBuy = readInt("How many acres will you buy? ")

          while (acresToBuy < 0 || acresToBuy * price > bushels)
          {
            println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
            acresToBuy = readInt("How many acres will you buy? ")
          }
          acresToBuy
        }


        def askHowMuchLandToSell(acres: Int) =
        {
          var acresToSell = readInt("How many acres will you sell? ")

          while ( acresToSell > acres)
          {
            println("O Great Hammurabi, we have but " + acres + " to sell!")
            acresToSell = readInt("How many acres will you sell? ")
          }
          acresToSell
        }

        def askHowMuchGrainToFeed(grain: Int) =
        {
          var howMuchGrain = readInt("How much grain to feed the poeple? ")

          while (howMuchGrain > grain)
          {
            println("O Great Hammurabi, we have but " + grain + "  grain!")
            howMuchGrain = readInt("How much grain to feed the poeple? ")
            if (grain > population * 20)
            {
              println("With all respect your greatness but feeding each person more than 20 bushels a year is a waste!")
            }
          }
          howMuchGrain
        }

        def askHowManyAcresToPlant(acres: Int) =
        {
          var howManyAcres = readInt("How many acres to plant ? ")

          while (howManyAcres > acres)
          {
            println("O Great Hammurabi, we have but " + acresOwned + "  grain!")
            howManyAcres = readInt("How many acres to plant ? ")
          }
          howManyAcres
        }

        println ( "O great Hammurabi!")
        println ( "You are in year " + year + " of your ten year rule. ")
        println ( "In the previous year " +  immigrants + " people entered the kingdom.")
        println ( "The population is now "  + population )
        println ( "We harvested " + harvest + " bushels at " + bushelsPerAcre + " bushels per acre.")
        println ( "Rats destroyed " + rats_ate + " bushels, leaving " + bushelsInStorage + " bushels in storage.")
        println ( "The city owns " + acresOwned + " acres of land.")
        println ( "Land is currently worth " + pricePerAcre + " bushels per acre.")
        println ( "There were " + plagueDeaths  + " deaths from the plague")
        println(" ")

        year  = year + 1

        var previousAcresOwned = acresOwned

        var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
        acresOwned = acresOwned + acresToBuy

        if (acresOwned == previousAcresOwned) // only ask how much land to sell if the player is not buying land
        {
          var acresToSell = askHowMuchLandToSell(acresOwned)
          acresOwned = acresOwned - acresToSell
          bushelsInStorage = bushelsInStorage + ( acresToSell * pricePerAcre )
        }

        var howMuchGrain = askHowMuchGrainToFeed(bushelsInStorage)
        bushelsInStorage = bushelsInStorage - howMuchGrain
        var howManyAcres =  askHowManyAcresToPlant(acresOwned)
        bushelsInStorage = bushelsInStorage +  (howManyAcres *  bushelsPerAcre)

        //if there is a plague
        var plague = Random.nextInt(100)+1
        if ( plague  >= 0 && plague <=15 )
        {
          population = population / 2
          println("There has been a terrible Plague, great Hammurabi!"+ starved + " people died! You overall population is now: "+ population)
          plagueDeaths = population / 2
        }
        //How many people starved
        if ( bushelsInStorage < (population * 20) )
        {
          starved = ((population * 20) - bushelsInStorage) / 20
        }
        //if more than 45% of the people starve, Hammurabi gets immediately SACKED!
        if ( plagueDeaths  > (population / 100) * 45)
        {
          println(" YOU KILLED LOTS OF PEOPLE. YOU ARE OUT OF HERE! GOODBYE...")
          year = 10
        }
        //How many people came to the city
        if ( starved == 0 )
        {
          immigrants = (20 * acresOwned + bushelsInStorage) / ( 100 * population ) + 1
          population  = population + immigrants
        }

        //How good the harvest is
        bushelsPerAcre = Random.nextInt(1&8)+1
        harvest = bushelsPerAcre * acresOwned



        // PROBLEM WITH RATS
        if ( Random.nextInt(40)+1 < 40 )
        {
          rats_ate = (bushelsInStorage / 100) * Random.nextInt(10&30)+1
        }

        //How much land will cost next year?
        pricePerAcre = Random.nextInt(17&23)+1

      }//end of while loop


    }//end of 'hammurabi' function


    hammurabi() // function called here











  }//end of main args
}//end of program


