/*    */ package mzm.gsp.item;
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
/*    */ public class SEquipTransferHunRes
/*    */   extends __SEquipTransferHunRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584751;
/*    */   public ArrayList<ExtraProBean> newexprolist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584751;
/*    */   }
/*    */   
/*    */ 
/*    */   public SEquipTransferHunRes()
/*    */   {
/* 31 */     this.newexprolist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SEquipTransferHunRes(ArrayList<ExtraProBean> _newexprolist_) {
/* 35 */     this.newexprolist = _newexprolist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     for (ExtraProBean _v_ : this.newexprolist)
/* 40 */       if (!_v_._validator_()) return false;
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.newexprolist.size());
/* 46 */     for (ExtraProBean _v_ : this.newexprolist) {
/* 47 */       _os_.marshal(_v_);
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 54 */       ExtraProBean _v_ = new ExtraProBean();
/* 55 */       _v_.unmarshal(_os_);
/* 56 */       this.newexprolist.add(_v_);
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SEquipTransferHunRes)) {
/* 67 */       SEquipTransferHunRes _o_ = (SEquipTransferHunRes)_o1_;
/* 68 */       if (!this.newexprolist.equals(_o_.newexprolist)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.newexprolist.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.newexprolist).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SEquipTransferHunRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */