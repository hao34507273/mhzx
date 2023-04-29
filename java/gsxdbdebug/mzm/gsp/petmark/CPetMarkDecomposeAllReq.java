/*    */ package mzm.gsp.petmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.petmark.main.PCPetMarkDecomposeAllReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPetMarkDecomposeAllReq
/*    */   extends __CPetMarkDecomposeAllReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628483;
/*    */   public ArrayList<Integer> decompose_qualities;
/*    */   public int decompose_max_level;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCPetMarkDecomposeAllReq(roleId, this.decompose_qualities, this.decompose_max_level));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12628483;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPetMarkDecomposeAllReq()
/*    */   {
/* 39 */     this.decompose_qualities = new ArrayList();
/*    */   }
/*    */   
/*    */   public CPetMarkDecomposeAllReq(ArrayList<Integer> _decompose_qualities_, int _decompose_max_level_) {
/* 43 */     this.decompose_qualities = _decompose_qualities_;
/* 44 */     this.decompose_max_level = _decompose_max_level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.compact_uint32(this.decompose_qualities.size());
/* 53 */     for (Integer _v_ : this.decompose_qualities) {
/* 54 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 56 */     _os_.marshal(this.decompose_max_level);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.decompose_qualities.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     this.decompose_max_level = _os_.unmarshal_int();
/* 67 */     if (!_validator_()) {
/* 68 */       throw new VerifyError("validator failed");
/*    */     }
/* 70 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 74 */     if (_o1_ == this) return true;
/* 75 */     if ((_o1_ instanceof CPetMarkDecomposeAllReq)) {
/* 76 */       CPetMarkDecomposeAllReq _o_ = (CPetMarkDecomposeAllReq)_o1_;
/* 77 */       if (!this.decompose_qualities.equals(_o_.decompose_qualities)) return false;
/* 78 */       if (this.decompose_max_level != _o_.decompose_max_level) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.decompose_qualities.hashCode();
/* 87 */     _h_ += this.decompose_max_level;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.decompose_qualities).append(",");
/* 95 */     _sb_.append(this.decompose_max_level).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\CPetMarkDecomposeAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */