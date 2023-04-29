/*    */ package mzm.gsp.task.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SNodeProperty implements Marshal
/*    */ {
/*    */   public int nextNodeId;
/*    */   public int turnNum;
/*    */   public int taskSetType;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.nextNodeId = Integer.valueOf(rootElement.attributeValue("nextNodeId")).intValue();
/* 16 */     this.turnNum = Integer.valueOf(rootElement.attributeValue("turnNum")).intValue();
/* 17 */     this.taskSetType = Integer.valueOf(rootElement.attributeValue("taskSetType")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.nextNodeId);
/* 23 */     _os_.marshal(this.turnNum);
/* 24 */     _os_.marshal(this.taskSetType);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.nextNodeId = _os_.unmarshal_int();
/* 31 */     this.turnNum = _os_.unmarshal_int();
/* 32 */     this.taskSetType = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\SNodeProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */