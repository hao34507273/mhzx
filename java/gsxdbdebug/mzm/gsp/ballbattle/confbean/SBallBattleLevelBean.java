/*    */ package mzm.gsp.ballbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SBallBattleLevelBean implements Marshal
/*    */ {
/*    */   public int speedOffset;
/*    */   public int radius;
/*    */   public int providedScore;
/*    */   public int providedGene;
/*    */   public int requiredGene;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.speedOffset = Integer.valueOf(rootElement.attributeValue("speedOffset")).intValue();
/* 18 */     this.radius = Integer.valueOf(rootElement.attributeValue("radius")).intValue();
/* 19 */     this.providedScore = Integer.valueOf(rootElement.attributeValue("providedScore")).intValue();
/* 20 */     this.providedGene = Integer.valueOf(rootElement.attributeValue("providedGene")).intValue();
/* 21 */     this.requiredGene = Integer.valueOf(rootElement.attributeValue("requiredGene")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 26 */     _os_.marshal(this.speedOffset);
/* 27 */     _os_.marshal(this.radius);
/* 28 */     _os_.marshal(this.providedScore);
/* 29 */     _os_.marshal(this.providedGene);
/* 30 */     _os_.marshal(this.requiredGene);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 36 */     this.speedOffset = _os_.unmarshal_int();
/* 37 */     this.radius = _os_.unmarshal_int();
/* 38 */     this.providedScore = _os_.unmarshal_int();
/* 39 */     this.providedGene = _os_.unmarshal_int();
/* 40 */     this.requiredGene = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\confbean\SBallBattleLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */