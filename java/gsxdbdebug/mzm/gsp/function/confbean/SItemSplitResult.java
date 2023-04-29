/*    */ package mzm.gsp.function.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SItemSplitResult implements Marshal
/*    */ {
/*    */   public int resultId;
/*    */   public int resultProbability;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.resultId = Integer.valueOf(rootElement.attributeValue("resultId")).intValue();
/* 15 */     this.resultProbability = Integer.valueOf(rootElement.attributeValue("resultProbability")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.resultId);
/* 21 */     _os_.marshal(this.resultProbability);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.resultId = _os_.unmarshal_int();
/* 28 */     this.resultProbability = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\function\confbean\SItemSplitResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */