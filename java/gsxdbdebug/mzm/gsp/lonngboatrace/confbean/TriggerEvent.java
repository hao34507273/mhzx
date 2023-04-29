/*    */ package mzm.gsp.lonngboatrace.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class TriggerEvent implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int eventTypeId;
/*    */   public int eventTriggerType;
/*    */   public int eventTimeType;
/*    */   public int eventTime;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 18 */     this.eventTypeId = Integer.valueOf(rootElement.attributeValue("eventTypeId")).intValue();
/* 19 */     this.eventTriggerType = Integer.valueOf(rootElement.attributeValue("eventTriggerType")).intValue();
/* 20 */     this.eventTimeType = Integer.valueOf(rootElement.attributeValue("eventTimeType")).intValue();
/* 21 */     this.eventTime = Integer.valueOf(rootElement.attributeValue("eventTime")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 26 */     _os_.marshal(this.id);
/* 27 */     _os_.marshal(this.eventTypeId);
/* 28 */     _os_.marshal(this.eventTriggerType);
/* 29 */     _os_.marshal(this.eventTimeType);
/* 30 */     _os_.marshal(this.eventTime);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 36 */     this.id = _os_.unmarshal_int();
/* 37 */     this.eventTypeId = _os_.unmarshal_int();
/* 38 */     this.eventTriggerType = _os_.unmarshal_int();
/* 39 */     this.eventTimeType = _os_.unmarshal_int();
/* 40 */     this.eventTime = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\confbean\TriggerEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */