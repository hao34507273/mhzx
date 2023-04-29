/*    */ package mzm.gsp.feisheng.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SubActivityCfgid implements Marshal
/*    */ {
/*    */   public int sub_activity_cfg_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 13 */     this.sub_activity_cfg_id = Integer.valueOf(rootElement.attributeValue("sub_activity_cfg_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 18 */     _os_.marshal(this.sub_activity_cfg_id);
/* 19 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 24 */     this.sub_activity_cfg_id = _os_.unmarshal_int();
/* 25 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\SubActivityCfgid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */