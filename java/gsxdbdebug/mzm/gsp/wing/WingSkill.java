/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class WingSkill implements Marshal
/*    */ {
/*    */   public int mainskillid;
/*    */   public ArrayList<Integer> subskillids;
/*    */   
/*    */   public WingSkill()
/*    */   {
/* 15 */     this.subskillids = new ArrayList();
/*    */   }
/*    */   
/*    */   public WingSkill(int _mainskillid_, ArrayList<Integer> _subskillids_) {
/* 19 */     this.mainskillid = _mainskillid_;
/* 20 */     this.subskillids = _subskillids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.mainskillid);
/* 29 */     _os_.compact_uint32(this.subskillids.size());
/* 30 */     for (Integer _v_ : this.subskillids) {
/* 31 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.mainskillid = _os_.unmarshal_int();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 40 */       int _v_ = _os_.unmarshal_int();
/* 41 */       this.subskillids.add(Integer.valueOf(_v_));
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof WingSkill)) {
/* 49 */       WingSkill _o_ = (WingSkill)_o1_;
/* 50 */       if (this.mainskillid != _o_.mainskillid) return false;
/* 51 */       if (!this.subskillids.equals(_o_.subskillids)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.mainskillid;
/* 60 */     _h_ += this.subskillids.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.mainskillid).append(",");
/* 68 */     _sb_.append(this.subskillids).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\WingSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */