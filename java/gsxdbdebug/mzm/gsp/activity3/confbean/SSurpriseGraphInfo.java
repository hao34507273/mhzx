/*    */ package mzm.gsp.activity3.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SSurpriseGraphInfo implements Marshal
/*    */ {
/*    */   public int surpriseType;
/*    */   public int activityId;
/*    */   public int openId;
/*    */   public int joinLevel;
/*    */   public int finishCount;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.surpriseType = Integer.valueOf(rootElement.attributeValue("surpriseType")).intValue();
/* 18 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/* 19 */     this.openId = Integer.valueOf(rootElement.attributeValue("openId")).intValue();
/* 20 */     this.joinLevel = Integer.valueOf(rootElement.attributeValue("joinLevel")).intValue();
/* 21 */     this.finishCount = Integer.valueOf(rootElement.attributeValue("finishCount")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 26 */     _os_.marshal(this.surpriseType);
/* 27 */     _os_.marshal(this.activityId);
/* 28 */     _os_.marshal(this.openId);
/* 29 */     _os_.marshal(this.joinLevel);
/* 30 */     _os_.marshal(this.finishCount);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 36 */     this.surpriseType = _os_.unmarshal_int();
/* 37 */     this.activityId = _os_.unmarshal_int();
/* 38 */     this.openId = _os_.unmarshal_int();
/* 39 */     this.joinLevel = _os_.unmarshal_int();
/* 40 */     this.finishCount = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SSurpriseGraphInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */