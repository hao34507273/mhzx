/*    */ package mzm.gsp.activity4.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SCreateAndCostInfo implements Marshal
/*    */ {
/*    */   public int costType;
/*    */   public int costNum;
/*    */   public int lifeSkillId;
/*    */   public int maxNum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.costType = Integer.valueOf(rootElement.attributeValue("costType")).intValue();
/* 17 */     this.costNum = Integer.valueOf(rootElement.attributeValue("costNum")).intValue();
/* 18 */     this.lifeSkillId = Integer.valueOf(rootElement.attributeValue("lifeSkillId")).intValue();
/* 19 */     this.maxNum = Integer.valueOf(rootElement.attributeValue("maxNum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.costType);
/* 25 */     _os_.marshal(this.costNum);
/* 26 */     _os_.marshal(this.lifeSkillId);
/* 27 */     _os_.marshal(this.maxNum);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.costType = _os_.unmarshal_int();
/* 34 */     this.costNum = _os_.unmarshal_int();
/* 35 */     this.lifeSkillId = _os_.unmarshal_int();
/* 36 */     this.maxNum = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SCreateAndCostInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */