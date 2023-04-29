/*     */ package mzm.gsp.christmasstocking;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SGetStockingInfoSuccess
/*     */   extends __SGetStockingInfoSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12629515;
/*     */   public static final int POSITION_STATE_EMPTY = 1;
/*     */   public static final int POSITION_HANGING = 2;
/*     */   public static final int POSITION_WITH_AWARD = 3;
/*     */   public long target_role_id;
/*     */   public Octets target_role_name;
/*     */   public ArrayList<HangStockingHistory> historys;
/*     */   public HashMap<Integer, Integer> position_state;
/*     */   public int self_hang_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12629515;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetStockingInfoSuccess()
/*     */   {
/*  41 */     this.target_role_name = new Octets();
/*  42 */     this.historys = new ArrayList();
/*  43 */     this.position_state = new HashMap();
/*     */   }
/*     */   
/*     */   public SGetStockingInfoSuccess(long _target_role_id_, Octets _target_role_name_, ArrayList<HangStockingHistory> _historys_, HashMap<Integer, Integer> _position_state_, int _self_hang_num_) {
/*  47 */     this.target_role_id = _target_role_id_;
/*  48 */     this.target_role_name = _target_role_name_;
/*  49 */     this.historys = _historys_;
/*  50 */     this.position_state = _position_state_;
/*  51 */     this.self_hang_num = _self_hang_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     for (HangStockingHistory _v_ : this.historys)
/*  56 */       if (!_v_._validator_()) return false;
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.target_role_id);
/*  62 */     _os_.marshal(this.target_role_name);
/*  63 */     _os_.compact_uint32(this.historys.size());
/*  64 */     for (HangStockingHistory _v_ : this.historys) {
/*  65 */       _os_.marshal(_v_);
/*     */     }
/*  67 */     _os_.compact_uint32(this.position_state.size());
/*  68 */     for (Map.Entry<Integer, Integer> _e_ : this.position_state.entrySet()) {
/*  69 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  70 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  72 */     _os_.marshal(this.self_hang_num);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  77 */     this.target_role_id = _os_.unmarshal_long();
/*  78 */     this.target_role_name = _os_.unmarshal_Octets();
/*  79 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  80 */       HangStockingHistory _v_ = new HangStockingHistory();
/*  81 */       _v_.unmarshal(_os_);
/*  82 */       this.historys.add(_v_);
/*     */     }
/*  84 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  86 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  88 */       int _v_ = _os_.unmarshal_int();
/*  89 */       this.position_state.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  91 */     this.self_hang_num = _os_.unmarshal_int();
/*  92 */     if (!_validator_()) {
/*  93 */       throw new VerifyError("validator failed");
/*     */     }
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  99 */     if (_o1_ == this) return true;
/* 100 */     if ((_o1_ instanceof SGetStockingInfoSuccess)) {
/* 101 */       SGetStockingInfoSuccess _o_ = (SGetStockingInfoSuccess)_o1_;
/* 102 */       if (this.target_role_id != _o_.target_role_id) return false;
/* 103 */       if (!this.target_role_name.equals(_o_.target_role_name)) return false;
/* 104 */       if (!this.historys.equals(_o_.historys)) return false;
/* 105 */       if (!this.position_state.equals(_o_.position_state)) return false;
/* 106 */       if (this.self_hang_num != _o_.self_hang_num) return false;
/* 107 */       return true;
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 113 */     int _h_ = 0;
/* 114 */     _h_ += (int)this.target_role_id;
/* 115 */     _h_ += this.target_role_name.hashCode();
/* 116 */     _h_ += this.historys.hashCode();
/* 117 */     _h_ += this.position_state.hashCode();
/* 118 */     _h_ += this.self_hang_num;
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this.target_role_id).append(",");
/* 126 */     _sb_.append("B").append(this.target_role_name.size()).append(",");
/* 127 */     _sb_.append(this.historys).append(",");
/* 128 */     _sb_.append(this.position_state).append(",");
/* 129 */     _sb_.append(this.self_hang_num).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\SGetStockingInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */