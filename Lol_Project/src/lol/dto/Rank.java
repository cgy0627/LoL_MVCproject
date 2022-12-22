//Rank.java

package lol.dto;

public enum Rank {
   BronzeV(1), BronzeIV(2), BronzeIII(3), BronzeII(4), BronzeI(5),
   SilverV(6), SilverIV(7), SilverIII(8), SilverII(9), SilverI(10),
   GoldV(11), GoldIV(12), GoldIII(13), GoldII(14), GoldI(15),
   PlatinumV(16), PlatinumIV(17), PlatinumIII(18), PlatinumII(19), PlatinumI(20),
   DiamondV(21), DiamondIV(22), DiamondIII(23), DiamondII(24), DiamondI(25),
   Challenger(26);

   private int rankCode;
   
   Rank() {};
   Rank(int rankCode) {
      this.rankCode = rankCode;
   }
   
   public int getRankCode() {
      return this.rankCode;
   }
}