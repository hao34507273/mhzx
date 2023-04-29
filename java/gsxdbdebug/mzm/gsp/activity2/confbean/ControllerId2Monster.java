/*    */ package mzm.gsp.activity2.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ControllerId2Monster implements Marshal
/*    */ {
/*    */   public int controllerId;
/*    */   public int triggerMonsterId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.controllerId = Integer.valueOf(rootElement.attributeValue("controllerId")).intValue();
/* 15 */     this.triggerMonsterId = Integer.valueOf(rootElement.attributeValue("triggerMonsterId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.controllerId);
/* 21 */     _os_.marshal(this.triggerMonsterId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.controllerId = _os_.unmarshal_int();
/* 28 */     this.triggerMonsterId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity2\confbean\ControllerId2Monster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */