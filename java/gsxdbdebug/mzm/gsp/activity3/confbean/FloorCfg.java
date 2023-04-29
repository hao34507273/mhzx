/*    */ package mzm.gsp.activity3.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FloorCfg implements Marshal
/*    */ {
/*    */   public int joinLevel;
/*    */   public int awardId;
/*    */   public int fristBloodAwardId;
/*    */   public int hardFightId;
/*    */   public int normalFightId;
/*    */   public int floorOpenId;
/*    */   public int fastFinishTimeLimit;
/*    */   public int helpLibId;
/*    */   public boolean canSweep;
/*    */   public int sweepFightValue;
/*    */   public int sweepCostNum;
/*    */   public int confirmType;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 24 */     this.joinLevel = Integer.valueOf(rootElement.attributeValue("joinLevel")).intValue();
/* 25 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/* 26 */     this.fristBloodAwardId = Integer.valueOf(rootElement.attributeValue("fristBloodAwardId")).intValue();
/* 27 */     this.hardFightId = Integer.valueOf(rootElement.attributeValue("hardFightId")).intValue();
/* 28 */     this.normalFightId = Integer.valueOf(rootElement.attributeValue("normalFightId")).intValue();
/* 29 */     this.floorOpenId = Integer.valueOf(rootElement.attributeValue("floorOpenId")).intValue();
/* 30 */     this.fastFinishTimeLimit = Integer.valueOf(rootElement.attributeValue("fastFinishTimeLimit")).intValue();
/* 31 */     this.helpLibId = Integer.valueOf(rootElement.attributeValue("helpLibId")).intValue();
/* 32 */     this.canSweep = Boolean.valueOf(rootElement.attributeValue("canSweep")).booleanValue();
/* 33 */     this.sweepFightValue = Integer.valueOf(rootElement.attributeValue("sweepFightValue")).intValue();
/* 34 */     this.sweepCostNum = Integer.valueOf(rootElement.attributeValue("sweepCostNum")).intValue();
/* 35 */     this.confirmType = Integer.valueOf(rootElement.attributeValue("confirmType")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 40 */     _os_.marshal(this.joinLevel);
/* 41 */     _os_.marshal(this.awardId);
/* 42 */     _os_.marshal(this.fristBloodAwardId);
/* 43 */     _os_.marshal(this.hardFightId);
/* 44 */     _os_.marshal(this.normalFightId);
/* 45 */     _os_.marshal(this.floorOpenId);
/* 46 */     _os_.marshal(this.fastFinishTimeLimit);
/* 47 */     _os_.marshal(this.helpLibId);
/* 48 */     _os_.marshal(this.canSweep);
/* 49 */     _os_.marshal(this.sweepFightValue);
/* 50 */     _os_.marshal(this.sweepCostNum);
/* 51 */     _os_.marshal(this.confirmType);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 57 */     this.joinLevel = _os_.unmarshal_int();
/* 58 */     this.awardId = _os_.unmarshal_int();
/* 59 */     this.fristBloodAwardId = _os_.unmarshal_int();
/* 60 */     this.hardFightId = _os_.unmarshal_int();
/* 61 */     this.normalFightId = _os_.unmarshal_int();
/* 62 */     this.floorOpenId = _os_.unmarshal_int();
/* 63 */     this.fastFinishTimeLimit = _os_.unmarshal_int();
/* 64 */     this.helpLibId = _os_.unmarshal_int();
/* 65 */     this.canSweep = _os_.unmarshal_boolean();
/* 66 */     this.sweepFightValue = _os_.unmarshal_int();
/* 67 */     this.sweepCostNum = _os_.unmarshal_int();
/* 68 */     this.confirmType = _os_.unmarshal_int();
/* 69 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\FloorCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */