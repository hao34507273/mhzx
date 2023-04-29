/*    */ package mzm.gsp.foolsday;
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
/*    */ public class SSynOpenChestMakerids
/*    */   extends __SSynOpenChestMakerids__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612876;
/*    */   public int activity_cfg_id;
/*    */   public ArrayList<Long> open_chest_maker_ids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612876;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynOpenChestMakerids()
/*    */   {
/* 34 */     this.open_chest_maker_ids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynOpenChestMakerids(int _activity_cfg_id_, ArrayList<Long> _open_chest_maker_ids_) {
/* 38 */     this.activity_cfg_id = _activity_cfg_id_;
/* 39 */     this.open_chest_maker_ids = _open_chest_maker_ids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.activity_cfg_id);
/* 48 */     _os_.compact_uint32(this.open_chest_maker_ids.size());
/* 49 */     for (Long _v_ : this.open_chest_maker_ids) {
/* 50 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       long _v_ = _os_.unmarshal_long();
/* 60 */       this.open_chest_maker_ids.add(Long.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSynOpenChestMakerids)) {
/* 71 */       SSynOpenChestMakerids _o_ = (SSynOpenChestMakerids)_o1_;
/* 72 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 73 */       if (!this.open_chest_maker_ids.equals(_o_.open_chest_maker_ids)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.activity_cfg_id;
/* 82 */     _h_ += this.open_chest_maker_ids.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.activity_cfg_id).append(",");
/* 90 */     _sb_.append(this.open_chest_maker_ids).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\SSynOpenChestMakerids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */