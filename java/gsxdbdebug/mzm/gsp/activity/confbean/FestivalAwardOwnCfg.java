/*    */ package mzm.gsp.activity.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FestivalAwardOwnCfg implements Marshal
/*    */ {
/*    */   public int cfgid;
/*    */   public String festivalName;
/*    */   public int startTimeSec;
/*    */   public int endTimeSec;
/*    */   public int giftid;
/*    */   public int notifyMailid;
/*    */   public int minLevel;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 19 */     this.cfgid = Integer.valueOf(rootElement.attributeValue("cfgid")).intValue();
/* 20 */     this.festivalName = rootElement.attributeValue("festivalName");
/* 21 */     this.startTimeSec = Integer.valueOf(rootElement.attributeValue("startTimeSec")).intValue();
/* 22 */     this.endTimeSec = Integer.valueOf(rootElement.attributeValue("endTimeSec")).intValue();
/* 23 */     this.giftid = Integer.valueOf(rootElement.attributeValue("giftid")).intValue();
/* 24 */     this.notifyMailid = Integer.valueOf(rootElement.attributeValue("notifyMailid")).intValue();
/* 25 */     this.minLevel = Integer.valueOf(rootElement.attributeValue("minLevel")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 30 */     _os_.marshal(this.cfgid);
/* 31 */     _os_.marshal(this.festivalName, "UTF-8");
/* 32 */     _os_.marshal(this.startTimeSec);
/* 33 */     _os_.marshal(this.endTimeSec);
/* 34 */     _os_.marshal(this.giftid);
/* 35 */     _os_.marshal(this.notifyMailid);
/* 36 */     _os_.marshal(this.minLevel);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 42 */     this.cfgid = _os_.unmarshal_int();
/* 43 */     this.festivalName = _os_.unmarshal_String("UTF-8");
/* 44 */     this.startTimeSec = _os_.unmarshal_int();
/* 45 */     this.endTimeSec = _os_.unmarshal_int();
/* 46 */     this.giftid = _os_.unmarshal_int();
/* 47 */     this.notifyMailid = _os_.unmarshal_int();
/* 48 */     this.minLevel = _os_.unmarshal_int();
/* 49 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\FestivalAwardOwnCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */