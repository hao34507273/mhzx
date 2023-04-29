/*    */ package mzm.gsp.feisheng.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class NeedPetInfo implements Marshal
/*    */ {
/*    */   public int pet_cfg_id;
/*    */   public int pet_num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.pet_cfg_id = Integer.valueOf(rootElement.attributeValue("pet_cfg_id")).intValue();
/* 15 */     this.pet_num = Integer.valueOf(rootElement.attributeValue("pet_num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.pet_cfg_id);
/* 21 */     _os_.marshal(this.pet_num);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.pet_cfg_id = _os_.unmarshal_int();
/* 28 */     this.pet_num = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\NeedPetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */