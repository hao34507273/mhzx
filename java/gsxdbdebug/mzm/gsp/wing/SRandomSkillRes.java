/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SRandomSkillRes
/*    */   extends __SRandomSkillRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596498;
/*    */   public int index;
/*    */   public int mainskillid;
/*    */   public ArrayList<Integer> subskillids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596498;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRandomSkillRes()
/*    */   {
/* 33 */     this.subskillids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SRandomSkillRes(int _index_, int _mainskillid_, ArrayList<Integer> _subskillids_) {
/* 37 */     this.index = _index_;
/* 38 */     this.mainskillid = _mainskillid_;
/* 39 */     this.subskillids = _subskillids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.index);
/* 48 */     _os_.marshal(this.mainskillid);
/* 49 */     _os_.compact_uint32(this.subskillids.size());
/* 50 */     for (Integer _v_ : this.subskillids) {
/* 51 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.index = _os_.unmarshal_int();
/* 58 */     this.mainskillid = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 61 */       int _v_ = _os_.unmarshal_int();
/* 62 */       this.subskillids.add(Integer.valueOf(_v_));
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SRandomSkillRes)) {
/* 73 */       SRandomSkillRes _o_ = (SRandomSkillRes)_o1_;
/* 74 */       if (this.index != _o_.index) return false;
/* 75 */       if (this.mainskillid != _o_.mainskillid) return false;
/* 76 */       if (!this.subskillids.equals(_o_.subskillids)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.index;
/* 85 */     _h_ += this.mainskillid;
/* 86 */     _h_ += this.subskillids.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.index).append(",");
/* 94 */     _sb_.append(this.mainskillid).append(",");
/* 95 */     _sb_.append(this.subskillids).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SRandomSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */