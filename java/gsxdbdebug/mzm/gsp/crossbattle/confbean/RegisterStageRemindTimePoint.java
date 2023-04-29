/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RegisterStageRemindTimePoint implements Marshal
/*    */ {
/*    */   public int register_stage_remind_hour;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 13 */     this.register_stage_remind_hour = Integer.valueOf(rootElement.attributeValue("register_stage_remind_hour")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 18 */     _os_.marshal(this.register_stage_remind_hour);
/* 19 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 24 */     this.register_stage_remind_hour = _os_.unmarshal_int();
/* 25 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\RegisterStageRemindTimePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */