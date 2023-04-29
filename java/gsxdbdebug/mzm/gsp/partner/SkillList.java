/*    */ package mzm.gsp.partner;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class SkillList implements Marshal
/*    */ {
/*    */   public ArrayList<Integer> skills;
/*    */   
/*    */   public SkillList()
/*    */   {
/* 14 */     this.skills = new ArrayList();
/*    */   }
/*    */   
/*    */   public SkillList(ArrayList<Integer> _skills_) {
/* 18 */     this.skills = _skills_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.skills.size());
/* 27 */     for (Integer _v_ : this.skills) {
/* 28 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 36 */       int _v_ = _os_.unmarshal_int();
/* 37 */       this.skills.add(Integer.valueOf(_v_));
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof SkillList)) {
/* 45 */       SkillList _o_ = (SkillList)_o1_;
/* 46 */       if (!this.skills.equals(_o_.skills)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.skills.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.skills).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SkillList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */