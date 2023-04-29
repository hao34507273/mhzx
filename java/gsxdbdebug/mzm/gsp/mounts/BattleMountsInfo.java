/*    */ package mzm.gsp.mounts;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class BattleMountsInfo implements Marshal
/*    */ {
/*    */   public long mounts_id;
/*    */   public int is_chief_battle_mounts;
/*    */   public ArrayList<Long> protect_pet_id_list;
/*    */   
/*    */   public BattleMountsInfo()
/*    */   {
/* 16 */     this.protect_pet_id_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public BattleMountsInfo(long _mounts_id_, int _is_chief_battle_mounts_, ArrayList<Long> _protect_pet_id_list_) {
/* 20 */     this.mounts_id = _mounts_id_;
/* 21 */     this.is_chief_battle_mounts = _is_chief_battle_mounts_;
/* 22 */     this.protect_pet_id_list = _protect_pet_id_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.mounts_id);
/* 31 */     _os_.marshal(this.is_chief_battle_mounts);
/* 32 */     _os_.compact_uint32(this.protect_pet_id_list.size());
/* 33 */     for (Long _v_ : this.protect_pet_id_list) {
/* 34 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.mounts_id = _os_.unmarshal_long();
/* 41 */     this.is_chief_battle_mounts = _os_.unmarshal_int();
/* 42 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 44 */       long _v_ = _os_.unmarshal_long();
/* 45 */       this.protect_pet_id_list.add(Long.valueOf(_v_));
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof BattleMountsInfo)) {
/* 53 */       BattleMountsInfo _o_ = (BattleMountsInfo)_o1_;
/* 54 */       if (this.mounts_id != _o_.mounts_id) return false;
/* 55 */       if (this.is_chief_battle_mounts != _o_.is_chief_battle_mounts) return false;
/* 56 */       if (!this.protect_pet_id_list.equals(_o_.protect_pet_id_list)) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += (int)this.mounts_id;
/* 65 */     _h_ += this.is_chief_battle_mounts;
/* 66 */     _h_ += this.protect_pet_id_list.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.mounts_id).append(",");
/* 74 */     _sb_.append(this.is_chief_battle_mounts).append(",");
/* 75 */     _sb_.append(this.protect_pet_id_list).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\BattleMountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */