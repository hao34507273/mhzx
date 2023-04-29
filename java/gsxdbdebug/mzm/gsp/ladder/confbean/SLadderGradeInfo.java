/*    */ package mzm.gsp.ladder.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SLadderGradeInfo implements Marshal
/*    */ {
/*    */   public String honorName;
/*    */   public int levelUpScoreMin;
/*    */   public int levelDownScoreMin;
/*    */   public int winToken;
/*    */   public int loseToken;
/*    */   public int awardid;
/*    */   public int reductionRate;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 19 */     this.honorName = rootElement.attributeValue("honorName");
/* 20 */     this.levelUpScoreMin = Integer.valueOf(rootElement.attributeValue("levelUpScoreMin")).intValue();
/* 21 */     this.levelDownScoreMin = Integer.valueOf(rootElement.attributeValue("levelDownScoreMin")).intValue();
/* 22 */     this.winToken = Integer.valueOf(rootElement.attributeValue("winToken")).intValue();
/* 23 */     this.loseToken = Integer.valueOf(rootElement.attributeValue("loseToken")).intValue();
/* 24 */     this.awardid = Integer.valueOf(rootElement.attributeValue("awardid")).intValue();
/* 25 */     this.reductionRate = Integer.valueOf(rootElement.attributeValue("reductionRate")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 30 */     _os_.marshal(this.honorName, "UTF-8");
/* 31 */     _os_.marshal(this.levelUpScoreMin);
/* 32 */     _os_.marshal(this.levelDownScoreMin);
/* 33 */     _os_.marshal(this.winToken);
/* 34 */     _os_.marshal(this.loseToken);
/* 35 */     _os_.marshal(this.awardid);
/* 36 */     _os_.marshal(this.reductionRate);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 42 */     this.honorName = _os_.unmarshal_String("UTF-8");
/* 43 */     this.levelUpScoreMin = _os_.unmarshal_int();
/* 44 */     this.levelDownScoreMin = _os_.unmarshal_int();
/* 45 */     this.winToken = _os_.unmarshal_int();
/* 46 */     this.loseToken = _os_.unmarshal_int();
/* 47 */     this.awardid = _os_.unmarshal_int();
/* 48 */     this.reductionRate = _os_.unmarshal_int();
/* 49 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\confbean\SLadderGradeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */