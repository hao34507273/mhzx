/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STPassiveSkillTypeTableInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int skillId;
/*    */   public int nextSkillId;
/*    */   public int beforeSkillId;
/*    */   public int index;
/* 13 */   public LinkedList<Integer> mutexList = new LinkedList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.skillId = Integer.valueOf(rootElement.attributeValue("skillId")).intValue();
/* 18 */     this.nextSkillId = Integer.valueOf(rootElement.attributeValue("nextSkillId")).intValue();
/* 19 */     this.beforeSkillId = Integer.valueOf(rootElement.attributeValue("beforeSkillId")).intValue();
/* 20 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/*    */     
/* 22 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "mutexList");
/* 23 */     if (collectionElement == null)
/*    */     {
/* 25 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 28 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 29 */     int _len = _nodeList.size();
/* 30 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 32 */       Element elem = (Element)_nodeList.get(i);
/* 33 */       if (elem.getName().equalsIgnoreCase("int"))
/*    */       {
/*    */         int _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 40 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 47 */         this.mutexList.add(Integer.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 54 */     _os_.marshal(this.skillId);
/* 55 */     _os_.marshal(this.nextSkillId);
/* 56 */     _os_.marshal(this.beforeSkillId);
/* 57 */     _os_.marshal(this.index);
/* 58 */     _os_.compact_uint32(this.mutexList.size());
/* 59 */     for (Integer _v_ : this.mutexList)
/*    */     {
/* 61 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 68 */     this.skillId = _os_.unmarshal_int();
/* 69 */     this.nextSkillId = _os_.unmarshal_int();
/* 70 */     this.beforeSkillId = _os_.unmarshal_int();
/* 71 */     this.index = _os_.unmarshal_int();
/* 72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 75 */       int _v_ = _os_.unmarshal_int();
/* 76 */       this.mutexList.add(Integer.valueOf(_v_));
/*    */     }
/* 78 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\STPassiveSkillTypeTableInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */