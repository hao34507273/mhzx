/*    */ package mzm.gsp.role;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetRoleFightValueRankRes
/*    */   extends __SGetRoleFightValueRankRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586021;
/*    */   public ArrayList<RoleFightValueRankData> ranklist;
/*    */   public int myno;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12586021;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetRoleFightValueRankRes()
/*    */   {
/* 34 */     this.ranklist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetRoleFightValueRankRes(ArrayList<RoleFightValueRankData> _ranklist_, int _myno_) {
/* 38 */     this.ranklist = _ranklist_;
/* 39 */     this.myno = _myno_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (RoleFightValueRankData _v_ : this.ranklist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.ranklist.size());
/* 50 */     for (RoleFightValueRankData _v_ : this.ranklist) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     _os_.marshal(this.myno);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 59 */       RoleFightValueRankData _v_ = new RoleFightValueRankData();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.ranklist.add(_v_);
/*    */     }
/* 63 */     this.myno = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SGetRoleFightValueRankRes)) {
/* 73 */       SGetRoleFightValueRankRes _o_ = (SGetRoleFightValueRankRes)_o1_;
/* 74 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 75 */       if (this.myno != _o_.myno) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.ranklist.hashCode();
/* 84 */     _h_ += this.myno;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.ranklist).append(",");
/* 92 */     _sb_.append(this.myno).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SGetRoleFightValueRankRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */