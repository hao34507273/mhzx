/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SEquipRes
/*    */   extends __SEquipRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584835;
/*    */   public HashSet<Long> uuids;
/*    */   public HashSet<Long> super_equipment_uuids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584835;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SEquipRes()
/*    */   {
/* 32 */     this.uuids = new HashSet();
/* 33 */     this.super_equipment_uuids = new HashSet();
/*    */   }
/*    */   
/*    */   public SEquipRes(HashSet<Long> _uuids_, HashSet<Long> _super_equipment_uuids_) {
/* 37 */     this.uuids = _uuids_;
/* 38 */     this.super_equipment_uuids = _super_equipment_uuids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.compact_uint32(this.uuids.size());
/* 47 */     for (Long _v_ : this.uuids) {
/* 48 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 50 */     _os_.compact_uint32(this.super_equipment_uuids.size());
/* 51 */     for (Long _v_ : this.super_equipment_uuids) {
/* 52 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 60 */       long _v_ = _os_.unmarshal_long();
/* 61 */       this.uuids.add(Long.valueOf(_v_));
/*    */     }
/* 63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 65 */       long _v_ = _os_.unmarshal_long();
/* 66 */       this.super_equipment_uuids.add(Long.valueOf(_v_));
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SEquipRes)) {
/* 77 */       SEquipRes _o_ = (SEquipRes)_o1_;
/* 78 */       if (!this.uuids.equals(_o_.uuids)) return false;
/* 79 */       if (!this.super_equipment_uuids.equals(_o_.super_equipment_uuids)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.uuids.hashCode();
/* 88 */     _h_ += this.super_equipment_uuids.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.uuids).append(",");
/* 96 */     _sb_.append(this.super_equipment_uuids).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SEquipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */