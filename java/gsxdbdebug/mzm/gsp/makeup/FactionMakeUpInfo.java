/*    */ package mzm.gsp.makeup;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class FactionMakeUpInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int activityid;
/*    */   public int curturn;
/*    */   public long starttime;
/*    */   public int questionid;
/*    */   public ArrayList<Integer> optionids;
/*    */   
/*    */   public FactionMakeUpInfo()
/*    */   {
/* 16 */     this.optionids = new ArrayList();
/*    */   }
/*    */   
/*    */   public FactionMakeUpInfo(int _activityid_, int _curturn_, long _starttime_, int _questionid_, ArrayList<Integer> _optionids_) {
/* 20 */     this.activityid = _activityid_;
/* 21 */     this.curturn = _curturn_;
/* 22 */     this.starttime = _starttime_;
/* 23 */     this.questionid = _questionid_;
/* 24 */     this.optionids = _optionids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.activityid);
/* 33 */     _os_.marshal(this.curturn);
/* 34 */     _os_.marshal(this.starttime);
/* 35 */     _os_.marshal(this.questionid);
/* 36 */     _os_.compact_uint32(this.optionids.size());
/* 37 */     for (Integer _v_ : this.optionids) {
/* 38 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.activityid = _os_.unmarshal_int();
/* 45 */     this.curturn = _os_.unmarshal_int();
/* 46 */     this.starttime = _os_.unmarshal_long();
/* 47 */     this.questionid = _os_.unmarshal_int();
/* 48 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 50 */       int _v_ = _os_.unmarshal_int();
/* 51 */       this.optionids.add(Integer.valueOf(_v_));
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof FactionMakeUpInfo)) {
/* 59 */       FactionMakeUpInfo _o_ = (FactionMakeUpInfo)_o1_;
/* 60 */       if (this.activityid != _o_.activityid) return false;
/* 61 */       if (this.curturn != _o_.curturn) return false;
/* 62 */       if (this.starttime != _o_.starttime) return false;
/* 63 */       if (this.questionid != _o_.questionid) return false;
/* 64 */       if (!this.optionids.equals(_o_.optionids)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.activityid;
/* 73 */     _h_ += this.curturn;
/* 74 */     _h_ += (int)this.starttime;
/* 75 */     _h_ += this.questionid;
/* 76 */     _h_ += this.optionids.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.activityid).append(",");
/* 84 */     _sb_.append(this.curturn).append(",");
/* 85 */     _sb_.append(this.starttime).append(",");
/* 86 */     _sb_.append(this.questionid).append(",");
/* 87 */     _sb_.append(this.optionids).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\FactionMakeUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */