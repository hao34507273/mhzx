/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SyncPointRacePromotion
/*    */   extends __SyncPointRacePromotion__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617051;
/*    */   public int activity_cfgid;
/*    */   public int zone;
/*    */   public ArrayList<Octets> promotions;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617051;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SyncPointRacePromotion()
/*    */   {
/* 35 */     this.promotions = new ArrayList();
/*    */   }
/*    */   
/*    */   public SyncPointRacePromotion(int _activity_cfgid_, int _zone_, ArrayList<Octets> _promotions_) {
/* 39 */     this.activity_cfgid = _activity_cfgid_;
/* 40 */     this.zone = _zone_;
/* 41 */     this.promotions = _promotions_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_cfgid);
/* 50 */     _os_.marshal(this.zone);
/* 51 */     _os_.compact_uint32(this.promotions.size());
/* 52 */     for (Octets _v_ : this.promotions) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.activity_cfgid = _os_.unmarshal_int();
/* 60 */     this.zone = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       Octets _v_ = _os_.unmarshal_Octets();
/* 64 */       this.promotions.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SyncPointRacePromotion)) {
/* 75 */       SyncPointRacePromotion _o_ = (SyncPointRacePromotion)_o1_;
/* 76 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 77 */       if (this.zone != _o_.zone) return false;
/* 78 */       if (!this.promotions.equals(_o_.promotions)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activity_cfgid;
/* 87 */     _h_ += this.zone;
/* 88 */     _h_ += this.promotions.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_cfgid).append(",");
/* 96 */     _sb_.append(this.zone).append(",");
/* 97 */     _sb_.append(this.promotions).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SyncPointRacePromotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */