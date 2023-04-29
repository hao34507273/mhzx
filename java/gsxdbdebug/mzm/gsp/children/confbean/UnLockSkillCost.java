/*    */ package mzm.gsp.children.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class UnLockSkillCost implements Marshal
/*    */ {
/*    */   public int unLockMainItem;
/*    */   public int unLocksubItem1;
/*    */   public int unLockItemNum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.unLockMainItem = Integer.valueOf(rootElement.attributeValue("unLockMainItem")).intValue();
/* 16 */     this.unLocksubItem1 = Integer.valueOf(rootElement.attributeValue("unLocksubItem1")).intValue();
/* 17 */     this.unLockItemNum = Integer.valueOf(rootElement.attributeValue("unLockItemNum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.unLockMainItem);
/* 23 */     _os_.marshal(this.unLocksubItem1);
/* 24 */     _os_.marshal(this.unLockItemNum);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.unLockMainItem = _os_.unmarshal_int();
/* 31 */     this.unLocksubItem1 = _os_.unmarshal_int();
/* 32 */     this.unLockItemNum = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\UnLockSkillCost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */