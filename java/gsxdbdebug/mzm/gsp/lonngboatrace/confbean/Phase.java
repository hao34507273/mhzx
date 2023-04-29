/*    */ package mzm.gsp.lonngboatrace.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class Phase implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int roundCount;
/*    */   public int timesCount;
/*    */   public int commandTime;
/*    */   public int tipTime;
/*    */   public int commandCount;
/*    */   public double speedUpUnit;
/*    */   public double maxSpeed;
/*    */   public double speedDownUnit;
/*    */   public double minSpeed;
/*    */   public int aIAccuracy;
/*    */   public int prepareTime;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 25 */     this.roundCount = Integer.valueOf(rootElement.attributeValue("roundCount")).intValue();
/* 26 */     this.timesCount = Integer.valueOf(rootElement.attributeValue("timesCount")).intValue();
/* 27 */     this.commandTime = Integer.valueOf(rootElement.attributeValue("commandTime")).intValue();
/* 28 */     this.tipTime = Integer.valueOf(rootElement.attributeValue("tipTime")).intValue();
/* 29 */     this.commandCount = Integer.valueOf(rootElement.attributeValue("commandCount")).intValue();
/* 30 */     this.speedUpUnit = Double.valueOf(rootElement.attributeValue("speedUpUnit")).doubleValue();
/* 31 */     this.maxSpeed = Double.valueOf(rootElement.attributeValue("maxSpeed")).doubleValue();
/* 32 */     this.speedDownUnit = Double.valueOf(rootElement.attributeValue("speedDownUnit")).doubleValue();
/* 33 */     this.minSpeed = Double.valueOf(rootElement.attributeValue("minSpeed")).doubleValue();
/* 34 */     this.aIAccuracy = Integer.valueOf(rootElement.attributeValue("aIAccuracy")).intValue();
/* 35 */     this.prepareTime = Integer.valueOf(rootElement.attributeValue("prepareTime")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 40 */     _os_.marshal(this.id);
/* 41 */     _os_.marshal(this.roundCount);
/* 42 */     _os_.marshal(this.timesCount);
/* 43 */     _os_.marshal(this.commandTime);
/* 44 */     _os_.marshal(this.tipTime);
/* 45 */     _os_.marshal(this.commandCount);
/* 46 */     _os_.marshal(this.speedUpUnit);
/* 47 */     _os_.marshal(this.maxSpeed);
/* 48 */     _os_.marshal(this.speedDownUnit);
/* 49 */     _os_.marshal(this.minSpeed);
/* 50 */     _os_.marshal(this.aIAccuracy);
/* 51 */     _os_.marshal(this.prepareTime);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 57 */     this.id = _os_.unmarshal_int();
/* 58 */     this.roundCount = _os_.unmarshal_int();
/* 59 */     this.timesCount = _os_.unmarshal_int();
/* 60 */     this.commandTime = _os_.unmarshal_int();
/* 61 */     this.tipTime = _os_.unmarshal_int();
/* 62 */     this.commandCount = _os_.unmarshal_int();
/* 63 */     this.speedUpUnit = _os_.unmarshal_float();
/* 64 */     this.maxSpeed = _os_.unmarshal_float();
/* 65 */     this.speedDownUnit = _os_.unmarshal_float();
/* 66 */     this.minSpeed = _os_.unmarshal_float();
/* 67 */     this.aIAccuracy = _os_.unmarshal_int();
/* 68 */     this.prepareTime = _os_.unmarshal_int();
/* 69 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\confbean\Phase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */