 
 //nazrawit tefera
 //date- jan 23, 2026
 //
public class Country
{
  // add private instance variables for the name, capital, language, and image file.
   private String country;
   private String language;
   private String image;
   private String capital;
  // add constructors
  public Country(){
    
  }
  public Country(String country, String capital, String language, String image ){
    this.country = country;
    this.language = language;
    this.image= image;
    this.capital= capital;
  }

  // Write accessor/get methods for each instance variable that returns it.
public String getCountry(){
  return country;
}
public String getLanguage(){
  return language;
}
public String getImage(){
  return image;
}
public String getCapital(){
  return capital;
}
  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
 
public String toString(){
  return country + "'s capital is " + capital + " and its primary language is " + language + ".";
}

  
}