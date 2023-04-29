/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class CorpsBriefInfo implements Marshal
/*    */ {
/*    */   public long corpsid;
/*    */   public Octets name;
/*    */   public int corpsbadgeid;
/*    */   public float average_fight_value;
/*    */   
/*    */   public CorpsBriefInfo()
/*    */   {
/* 17 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public CorpsBriefInfo(long _corpsid_, Octets _name_, int _corpsbadgeid_, float _average_fight_value_) {
/* 21 */     this.corpsid = _corpsid_;
/* 22 */     this.name = _name_;
/* 23 */     this.corpsbadgeid = _corpsbadgeid_;
/* 24 */     this.average_fight_value = _average_fight_value_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.corpsid);
/* 33 */     _os_.marshal(this.name);
/* 34 */     _os_.marshal(this.corpsbadgeid);
/* 35 */     _os_.marshal(this.average_fight_value);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.corpsid = _os_.unmarshal_long();
/* 41 */     this.name = _os_.unmarshal_Octets();
/* 42 */     this.corpsbadgeid = _os_.unmarshal_int();
/* 43 */     this.average_fight_value = _os_.unmarshal_float();
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof CorpsBriefInfo)) {
/* 50 */       CorpsBriefInfo _o_ = (CorpsBriefInfo)_o1_;
/* 51 */       if (this.corpsid != _o_.corpsid) return false;
/* 52 */       if (!this.name.equals(_o_.name)) return false;
/* 53 */       if (this.corpsbadgeid != _o_.corpsbadgeid) return false;
/* 54 */       if (this.average_fight_value != _o_.average_fight_value) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += (int)this.corpsid;
/* 63 */     _h_ += this.name.hashCode();
/* 64 */     _h_ += this.corpsbadgeid;
/* 65 */     _h_ += Float.floatToIntBits(this.average_fight_value);
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append(this.corpsid).append(",");
/* 73 */     _sb_.append("B").append(this.name.size()).append(",");
/* 74 */     _sb_.append(this.corpsbadgeid).append(",");
/* 75 */     _sb_.append(this.average_fight_value).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CorpsBriefInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */