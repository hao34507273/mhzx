/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class GrcReceiveAllGiftArg implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets to_account;
/*    */   public long to_roleid;
/*    */   public HashMap<Integer, Integer> gift_type_to_max_receive_times_everyday;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public GrcReceiveAllGiftArg()
/*    */   {
/* 18 */     this.to_account = new Octets();
/* 19 */     this.gift_type_to_max_receive_times_everyday = new HashMap();
/* 20 */     this.reserved1 = 0;
/* 21 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public GrcReceiveAllGiftArg(Octets _to_account_, long _to_roleid_, HashMap<Integer, Integer> _gift_type_to_max_receive_times_everyday_, int _reserved1_, int _reserved2_) {
/* 25 */     this.to_account = _to_account_;
/* 26 */     this.to_roleid = _to_roleid_;
/* 27 */     this.gift_type_to_max_receive_times_everyday = _gift_type_to_max_receive_times_everyday_;
/* 28 */     this.reserved1 = _reserved1_;
/* 29 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.to_account);
/* 38 */     _os_.marshal(this.to_roleid);
/* 39 */     _os_.compact_uint32(this.gift_type_to_max_receive_times_everyday.size());
/* 40 */     for (Map.Entry<Integer, Integer> _e_ : this.gift_type_to_max_receive_times_everyday.entrySet()) {
/* 41 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 42 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 44 */     _os_.marshal(this.reserved1);
/* 45 */     _os_.marshal(this.reserved2);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 50 */     this.to_account = _os_.unmarshal_Octets();
/* 51 */     this.to_roleid = _os_.unmarshal_long();
/* 52 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 54 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 56 */       int _v_ = _os_.unmarshal_int();
/* 57 */       this.gift_type_to_max_receive_times_everyday.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 59 */     this.reserved1 = _os_.unmarshal_int();
/* 60 */     this.reserved2 = _os_.unmarshal_int();
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof GrcReceiveAllGiftArg)) {
/* 67 */       GrcReceiveAllGiftArg _o_ = (GrcReceiveAllGiftArg)_o1_;
/* 68 */       if (!this.to_account.equals(_o_.to_account)) return false;
/* 69 */       if (this.to_roleid != _o_.to_roleid) return false;
/* 70 */       if (!this.gift_type_to_max_receive_times_everyday.equals(_o_.gift_type_to_max_receive_times_everyday)) return false;
/* 71 */       if (this.reserved1 != _o_.reserved1) return false;
/* 72 */       if (this.reserved2 != _o_.reserved2) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.to_account.hashCode();
/* 81 */     _h_ += (int)this.to_roleid;
/* 82 */     _h_ += this.gift_type_to_max_receive_times_everyday.hashCode();
/* 83 */     _h_ += this.reserved1;
/* 84 */     _h_ += this.reserved2;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append("B").append(this.to_account.size()).append(",");
/* 92 */     _sb_.append(this.to_roleid).append(",");
/* 93 */     _sb_.append(this.gift_type_to_max_receive_times_everyday).append(",");
/* 94 */     _sb_.append(this.reserved1).append(",");
/* 95 */     _sb_.append(this.reserved2).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcReceiveAllGiftArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */