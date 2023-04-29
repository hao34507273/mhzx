/*    */ package mzm.gsp.item.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class EquipSkillWeight implements Marshal
/*    */ {
/*    */   public int skillid;
/*    */   public int weight;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.skillid = Integer.valueOf(rootElement.attributeValue("skillid")).intValue();
/* 15 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.skillid);
/* 21 */     _os_.marshal(this.weight);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.skillid = _os_.unmarshal_int();
/* 28 */     this.weight = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\EquipSkillWeight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */