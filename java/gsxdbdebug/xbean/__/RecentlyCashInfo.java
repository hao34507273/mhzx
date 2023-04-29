/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class RecentlyCashInfo extends XBean implements xbean.RecentlyCashInfo
/*      */ {
/*      */   private ArrayList<xbean.DaySaveAmtInfo> day_save_amt_list;
/*      */   private long last_week_cash_amt;
/*      */   private long last_two_week_cash_amt;
/*      */   private long last_month_cash_amt;
/*      */   private long last_cash_amt_refresh_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.day_save_amt_list.clear();
/*   27 */     this.last_week_cash_amt = 0L;
/*   28 */     this.last_two_week_cash_amt = 0L;
/*   29 */     this.last_month_cash_amt = 0L;
/*   30 */     this.last_cash_amt_refresh_time = 0L;
/*      */   }
/*      */   
/*      */   RecentlyCashInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.day_save_amt_list = new ArrayList();
/*      */   }
/*      */   
/*      */   public RecentlyCashInfo()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RecentlyCashInfo(RecentlyCashInfo _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RecentlyCashInfo(xbean.RecentlyCashInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof RecentlyCashInfo)) { assign((RecentlyCashInfo)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RecentlyCashInfo _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.day_save_amt_list = new ArrayList();
/*   62 */     for (xbean.DaySaveAmtInfo _v_ : _o_.day_save_amt_list)
/*   63 */       this.day_save_amt_list.add(new DaySaveAmtInfo(_v_, this, "day_save_amt_list"));
/*   64 */     this.last_week_cash_amt = _o_.last_week_cash_amt;
/*   65 */     this.last_two_week_cash_amt = _o_.last_two_week_cash_amt;
/*   66 */     this.last_month_cash_amt = _o_.last_month_cash_amt;
/*   67 */     this.last_cash_amt_refresh_time = _o_.last_cash_amt_refresh_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   72 */     this.day_save_amt_list = new ArrayList();
/*   73 */     for (xbean.DaySaveAmtInfo _v_ : _o_.day_save_amt_list)
/*   74 */       this.day_save_amt_list.add(new DaySaveAmtInfo(_v_, this, "day_save_amt_list"));
/*   75 */     this.last_week_cash_amt = _o_.last_week_cash_amt;
/*   76 */     this.last_two_week_cash_amt = _o_.last_two_week_cash_amt;
/*   77 */     this.last_month_cash_amt = _o_.last_month_cash_amt;
/*   78 */     this.last_cash_amt_refresh_time = _o_.last_cash_amt_refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.compact_uint32(this.day_save_amt_list.size());
/*   86 */     for (xbean.DaySaveAmtInfo _v_ : this.day_save_amt_list)
/*      */     {
/*   88 */       _v_.marshal(_os_);
/*      */     }
/*   90 */     _os_.marshal(this.last_week_cash_amt);
/*   91 */     _os_.marshal(this.last_two_week_cash_amt);
/*   92 */     _os_.marshal(this.last_month_cash_amt);
/*   93 */     _os_.marshal(this.last_cash_amt_refresh_time);
/*   94 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  100 */     _xdb_verify_unsafe_();
/*  101 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  103 */       xbean.DaySaveAmtInfo _v_ = new DaySaveAmtInfo(0, this, "day_save_amt_list");
/*  104 */       _v_.unmarshal(_os_);
/*  105 */       this.day_save_amt_list.add(_v_);
/*      */     }
/*  107 */     this.last_week_cash_amt = _os_.unmarshal_long();
/*  108 */     this.last_two_week_cash_amt = _os_.unmarshal_long();
/*  109 */     this.last_month_cash_amt = _os_.unmarshal_long();
/*  110 */     this.last_cash_amt_refresh_time = _os_.unmarshal_long();
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     int _size_ = 0;
/*  119 */     for (xbean.DaySaveAmtInfo _v_ : this.day_save_amt_list)
/*      */     {
/*  121 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */     }
/*  123 */     _size_ += CodedOutputStream.computeInt64Size(2, this.last_week_cash_amt);
/*  124 */     _size_ += CodedOutputStream.computeInt64Size(3, this.last_two_week_cash_amt);
/*  125 */     _size_ += CodedOutputStream.computeInt64Size(4, this.last_month_cash_amt);
/*  126 */     _size_ += CodedOutputStream.computeInt64Size(5, this.last_cash_amt_refresh_time);
/*  127 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  133 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  136 */       for (xbean.DaySaveAmtInfo _v_ : this.day_save_amt_list)
/*      */       {
/*  138 */         _output_.writeMessage(1, _v_);
/*      */       }
/*  140 */       _output_.writeInt64(2, this.last_week_cash_amt);
/*  141 */       _output_.writeInt64(3, this.last_two_week_cash_amt);
/*  142 */       _output_.writeInt64(4, this.last_month_cash_amt);
/*  143 */       _output_.writeInt64(5, this.last_cash_amt_refresh_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  147 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  149 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  155 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  158 */       boolean done = false;
/*  159 */       while (!done)
/*      */       {
/*  161 */         int tag = _input_.readTag();
/*  162 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  166 */           done = true;
/*  167 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  171 */           xbean.DaySaveAmtInfo _v_ = new DaySaveAmtInfo(0, this, "day_save_amt_list");
/*  172 */           _input_.readMessage(_v_);
/*  173 */           this.day_save_amt_list.add(_v_);
/*  174 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  178 */           this.last_week_cash_amt = _input_.readInt64();
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  183 */           this.last_two_week_cash_amt = _input_.readInt64();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  188 */           this.last_month_cash_amt = _input_.readInt64();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  193 */           this.last_cash_amt_refresh_time = _input_.readInt64();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  198 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  200 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  209 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  213 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  215 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecentlyCashInfo copy()
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*  222 */     return new RecentlyCashInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecentlyCashInfo toData()
/*      */   {
/*  228 */     _xdb_verify_unsafe_();
/*  229 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RecentlyCashInfo toBean()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new RecentlyCashInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecentlyCashInfo toDataIf()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RecentlyCashInfo toBeanIf()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.DaySaveAmtInfo> getDay_save_amt_list()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return xdb.Logs.logList(new LogKey(this, "day_save_amt_list"), this.day_save_amt_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.DaySaveAmtInfo> getDay_save_amt_listAsData()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*      */     
/*  271 */     RecentlyCashInfo _o_ = this;
/*  272 */     List<xbean.DaySaveAmtInfo> day_save_amt_list = new ArrayList();
/*  273 */     for (xbean.DaySaveAmtInfo _v_ : _o_.day_save_amt_list)
/*  274 */       day_save_amt_list.add(new DaySaveAmtInfo.Data(_v_));
/*  275 */     return day_save_amt_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_week_cash_amt()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return this.last_week_cash_amt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_two_week_cash_amt()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return this.last_two_week_cash_amt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_month_cash_amt()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return this.last_month_cash_amt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_cash_amt_refresh_time()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return this.last_cash_amt_refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_week_cash_amt(long _v_)
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     xdb.Logs.logIf(new LogKey(this, "last_week_cash_amt")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  319 */         new LogLong(this, RecentlyCashInfo.this.last_week_cash_amt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  323 */             RecentlyCashInfo.this.last_week_cash_amt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  327 */     });
/*  328 */     this.last_week_cash_amt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_two_week_cash_amt(long _v_)
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     xdb.Logs.logIf(new LogKey(this, "last_two_week_cash_amt")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  340 */         new LogLong(this, RecentlyCashInfo.this.last_two_week_cash_amt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  344 */             RecentlyCashInfo.this.last_two_week_cash_amt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  348 */     });
/*  349 */     this.last_two_week_cash_amt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_month_cash_amt(long _v_)
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     xdb.Logs.logIf(new LogKey(this, "last_month_cash_amt")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  361 */         new LogLong(this, RecentlyCashInfo.this.last_month_cash_amt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  365 */             RecentlyCashInfo.this.last_month_cash_amt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  369 */     });
/*  370 */     this.last_month_cash_amt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_cash_amt_refresh_time(long _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     xdb.Logs.logIf(new LogKey(this, "last_cash_amt_refresh_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  382 */         new LogLong(this, RecentlyCashInfo.this.last_cash_amt_refresh_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             RecentlyCashInfo.this.last_cash_amt_refresh_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.last_cash_amt_refresh_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     RecentlyCashInfo _o_ = null;
/*  399 */     if ((_o1_ instanceof RecentlyCashInfo)) { _o_ = (RecentlyCashInfo)_o1_;
/*  400 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  401 */       return false;
/*  402 */     if (!this.day_save_amt_list.equals(_o_.day_save_amt_list)) return false;
/*  403 */     if (this.last_week_cash_amt != _o_.last_week_cash_amt) return false;
/*  404 */     if (this.last_two_week_cash_amt != _o_.last_two_week_cash_amt) return false;
/*  405 */     if (this.last_month_cash_amt != _o_.last_month_cash_amt) return false;
/*  406 */     if (this.last_cash_amt_refresh_time != _o_.last_cash_amt_refresh_time) return false;
/*  407 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*  414 */     int _h_ = 0;
/*  415 */     _h_ += this.day_save_amt_list.hashCode();
/*  416 */     _h_ = (int)(_h_ + this.last_week_cash_amt);
/*  417 */     _h_ = (int)(_h_ + this.last_two_week_cash_amt);
/*  418 */     _h_ = (int)(_h_ + this.last_month_cash_amt);
/*  419 */     _h_ = (int)(_h_ + this.last_cash_amt_refresh_time);
/*  420 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*  427 */     StringBuilder _sb_ = new StringBuilder();
/*  428 */     _sb_.append("(");
/*  429 */     _sb_.append(this.day_save_amt_list);
/*  430 */     _sb_.append(",");
/*  431 */     _sb_.append(this.last_week_cash_amt);
/*  432 */     _sb_.append(",");
/*  433 */     _sb_.append(this.last_two_week_cash_amt);
/*  434 */     _sb_.append(",");
/*  435 */     _sb_.append(this.last_month_cash_amt);
/*  436 */     _sb_.append(",");
/*  437 */     _sb_.append(this.last_cash_amt_refresh_time);
/*  438 */     _sb_.append(")");
/*  439 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  445 */     ListenableBean lb = new ListenableBean();
/*  446 */     lb.add(new ListenableChanged().setVarName("day_save_amt_list"));
/*  447 */     lb.add(new ListenableChanged().setVarName("last_week_cash_amt"));
/*  448 */     lb.add(new ListenableChanged().setVarName("last_two_week_cash_amt"));
/*  449 */     lb.add(new ListenableChanged().setVarName("last_month_cash_amt"));
/*  450 */     lb.add(new ListenableChanged().setVarName("last_cash_amt_refresh_time"));
/*  451 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RecentlyCashInfo {
/*      */     private Const() {}
/*      */     
/*      */     RecentlyCashInfo nThis() {
/*  458 */       return RecentlyCashInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  464 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecentlyCashInfo copy()
/*      */     {
/*  470 */       return RecentlyCashInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecentlyCashInfo toData()
/*      */     {
/*  476 */       return RecentlyCashInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RecentlyCashInfo toBean()
/*      */     {
/*  481 */       return RecentlyCashInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecentlyCashInfo toDataIf()
/*      */     {
/*  487 */       return RecentlyCashInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RecentlyCashInfo toBeanIf()
/*      */     {
/*  492 */       return RecentlyCashInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.DaySaveAmtInfo> getDay_save_amt_list()
/*      */     {
/*  499 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  500 */       return xdb.Consts.constList(RecentlyCashInfo.this.day_save_amt_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.DaySaveAmtInfo> getDay_save_amt_listAsData()
/*      */     {
/*  506 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*      */       
/*  508 */       RecentlyCashInfo _o_ = RecentlyCashInfo.this;
/*  509 */       List<xbean.DaySaveAmtInfo> day_save_amt_list = new ArrayList();
/*  510 */       for (xbean.DaySaveAmtInfo _v_ : _o_.day_save_amt_list)
/*  511 */         day_save_amt_list.add(new DaySaveAmtInfo.Data(_v_));
/*  512 */       return day_save_amt_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_week_cash_amt()
/*      */     {
/*  519 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  520 */       return RecentlyCashInfo.this.last_week_cash_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_two_week_cash_amt()
/*      */     {
/*  527 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  528 */       return RecentlyCashInfo.this.last_two_week_cash_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_month_cash_amt()
/*      */     {
/*  535 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  536 */       return RecentlyCashInfo.this.last_month_cash_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_cash_amt_refresh_time()
/*      */     {
/*  543 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  544 */       return RecentlyCashInfo.this.last_cash_amt_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_week_cash_amt(long _v_)
/*      */     {
/*  551 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  552 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_two_week_cash_amt(long _v_)
/*      */     {
/*  559 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  560 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_month_cash_amt(long _v_)
/*      */     {
/*  567 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  568 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_cash_amt_refresh_time(long _v_)
/*      */     {
/*  575 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  576 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  582 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  583 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  589 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  590 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  596 */       return RecentlyCashInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  602 */       return RecentlyCashInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  608 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  609 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  615 */       return RecentlyCashInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  621 */       return RecentlyCashInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  627 */       RecentlyCashInfo.this._xdb_verify_unsafe_();
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  634 */       return RecentlyCashInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  640 */       return RecentlyCashInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  646 */       return RecentlyCashInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  652 */       return RecentlyCashInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  658 */       return RecentlyCashInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  664 */       return RecentlyCashInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  670 */       return RecentlyCashInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RecentlyCashInfo
/*      */   {
/*      */     private ArrayList<xbean.DaySaveAmtInfo> day_save_amt_list;
/*      */     
/*      */     private long last_week_cash_amt;
/*      */     
/*      */     private long last_two_week_cash_amt;
/*      */     
/*      */     private long last_month_cash_amt;
/*      */     
/*      */     private long last_cash_amt_refresh_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  690 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  695 */       this.day_save_amt_list = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.RecentlyCashInfo _o1_)
/*      */     {
/*  700 */       if ((_o1_ instanceof RecentlyCashInfo)) { assign((RecentlyCashInfo)_o1_);
/*  701 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  702 */       } else if ((_o1_ instanceof RecentlyCashInfo.Const)) assign(((RecentlyCashInfo.Const)_o1_).nThis()); else {
/*  703 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RecentlyCashInfo _o_) {
/*  708 */       this.day_save_amt_list = new ArrayList();
/*  709 */       for (xbean.DaySaveAmtInfo _v_ : _o_.day_save_amt_list)
/*  710 */         this.day_save_amt_list.add(new DaySaveAmtInfo.Data(_v_));
/*  711 */       this.last_week_cash_amt = _o_.last_week_cash_amt;
/*  712 */       this.last_two_week_cash_amt = _o_.last_two_week_cash_amt;
/*  713 */       this.last_month_cash_amt = _o_.last_month_cash_amt;
/*  714 */       this.last_cash_amt_refresh_time = _o_.last_cash_amt_refresh_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  719 */       this.day_save_amt_list = new ArrayList();
/*  720 */       for (xbean.DaySaveAmtInfo _v_ : _o_.day_save_amt_list)
/*  721 */         this.day_save_amt_list.add(new DaySaveAmtInfo.Data(_v_));
/*  722 */       this.last_week_cash_amt = _o_.last_week_cash_amt;
/*  723 */       this.last_two_week_cash_amt = _o_.last_two_week_cash_amt;
/*  724 */       this.last_month_cash_amt = _o_.last_month_cash_amt;
/*  725 */       this.last_cash_amt_refresh_time = _o_.last_cash_amt_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  731 */       _os_.compact_uint32(this.day_save_amt_list.size());
/*  732 */       for (xbean.DaySaveAmtInfo _v_ : this.day_save_amt_list)
/*      */       {
/*  734 */         _v_.marshal(_os_);
/*      */       }
/*  736 */       _os_.marshal(this.last_week_cash_amt);
/*  737 */       _os_.marshal(this.last_two_week_cash_amt);
/*  738 */       _os_.marshal(this.last_month_cash_amt);
/*  739 */       _os_.marshal(this.last_cash_amt_refresh_time);
/*  740 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  746 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  748 */         xbean.DaySaveAmtInfo _v_ = xbean.Pod.newDaySaveAmtInfoData();
/*  749 */         _v_.unmarshal(_os_);
/*  750 */         this.day_save_amt_list.add(_v_);
/*      */       }
/*  752 */       this.last_week_cash_amt = _os_.unmarshal_long();
/*  753 */       this.last_two_week_cash_amt = _os_.unmarshal_long();
/*  754 */       this.last_month_cash_amt = _os_.unmarshal_long();
/*  755 */       this.last_cash_amt_refresh_time = _os_.unmarshal_long();
/*  756 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  762 */       int _size_ = 0;
/*  763 */       for (xbean.DaySaveAmtInfo _v_ : this.day_save_amt_list)
/*      */       {
/*  765 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */       }
/*  767 */       _size_ += CodedOutputStream.computeInt64Size(2, this.last_week_cash_amt);
/*  768 */       _size_ += CodedOutputStream.computeInt64Size(3, this.last_two_week_cash_amt);
/*  769 */       _size_ += CodedOutputStream.computeInt64Size(4, this.last_month_cash_amt);
/*  770 */       _size_ += CodedOutputStream.computeInt64Size(5, this.last_cash_amt_refresh_time);
/*  771 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  779 */         for (xbean.DaySaveAmtInfo _v_ : this.day_save_amt_list)
/*      */         {
/*  781 */           _output_.writeMessage(1, _v_);
/*      */         }
/*  783 */         _output_.writeInt64(2, this.last_week_cash_amt);
/*  784 */         _output_.writeInt64(3, this.last_two_week_cash_amt);
/*  785 */         _output_.writeInt64(4, this.last_month_cash_amt);
/*  786 */         _output_.writeInt64(5, this.last_cash_amt_refresh_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  790 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  792 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  800 */         boolean done = false;
/*  801 */         while (!done)
/*      */         {
/*  803 */           int tag = _input_.readTag();
/*  804 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  808 */             done = true;
/*  809 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  813 */             xbean.DaySaveAmtInfo _v_ = xbean.Pod.newDaySaveAmtInfoData();
/*  814 */             _input_.readMessage(_v_);
/*  815 */             this.day_save_amt_list.add(_v_);
/*  816 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  820 */             this.last_week_cash_amt = _input_.readInt64();
/*  821 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  825 */             this.last_two_week_cash_amt = _input_.readInt64();
/*  826 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  830 */             this.last_month_cash_amt = _input_.readInt64();
/*  831 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  835 */             this.last_cash_amt_refresh_time = _input_.readInt64();
/*  836 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  840 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  842 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  851 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  855 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  857 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecentlyCashInfo copy()
/*      */     {
/*  863 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecentlyCashInfo toData()
/*      */     {
/*  869 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RecentlyCashInfo toBean()
/*      */     {
/*  874 */       return new RecentlyCashInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecentlyCashInfo toDataIf()
/*      */     {
/*  880 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RecentlyCashInfo toBeanIf()
/*      */     {
/*  885 */       return new RecentlyCashInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  891 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  895 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  903 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  907 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  911 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  915 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.DaySaveAmtInfo> getDay_save_amt_list()
/*      */     {
/*  922 */       return this.day_save_amt_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.DaySaveAmtInfo> getDay_save_amt_listAsData()
/*      */     {
/*  929 */       return this.day_save_amt_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_week_cash_amt()
/*      */     {
/*  936 */       return this.last_week_cash_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_two_week_cash_amt()
/*      */     {
/*  943 */       return this.last_two_week_cash_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_month_cash_amt()
/*      */     {
/*  950 */       return this.last_month_cash_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_cash_amt_refresh_time()
/*      */     {
/*  957 */       return this.last_cash_amt_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_week_cash_amt(long _v_)
/*      */     {
/*  964 */       this.last_week_cash_amt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_two_week_cash_amt(long _v_)
/*      */     {
/*  971 */       this.last_two_week_cash_amt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_month_cash_amt(long _v_)
/*      */     {
/*  978 */       this.last_month_cash_amt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_cash_amt_refresh_time(long _v_)
/*      */     {
/*  985 */       this.last_cash_amt_refresh_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  991 */       if (!(_o1_ instanceof Data)) return false;
/*  992 */       Data _o_ = (Data)_o1_;
/*  993 */       if (!this.day_save_amt_list.equals(_o_.day_save_amt_list)) return false;
/*  994 */       if (this.last_week_cash_amt != _o_.last_week_cash_amt) return false;
/*  995 */       if (this.last_two_week_cash_amt != _o_.last_two_week_cash_amt) return false;
/*  996 */       if (this.last_month_cash_amt != _o_.last_month_cash_amt) return false;
/*  997 */       if (this.last_cash_amt_refresh_time != _o_.last_cash_amt_refresh_time) return false;
/*  998 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1004 */       int _h_ = 0;
/* 1005 */       _h_ += this.day_save_amt_list.hashCode();
/* 1006 */       _h_ = (int)(_h_ + this.last_week_cash_amt);
/* 1007 */       _h_ = (int)(_h_ + this.last_two_week_cash_amt);
/* 1008 */       _h_ = (int)(_h_ + this.last_month_cash_amt);
/* 1009 */       _h_ = (int)(_h_ + this.last_cash_amt_refresh_time);
/* 1010 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1016 */       StringBuilder _sb_ = new StringBuilder();
/* 1017 */       _sb_.append("(");
/* 1018 */       _sb_.append(this.day_save_amt_list);
/* 1019 */       _sb_.append(",");
/* 1020 */       _sb_.append(this.last_week_cash_amt);
/* 1021 */       _sb_.append(",");
/* 1022 */       _sb_.append(this.last_two_week_cash_amt);
/* 1023 */       _sb_.append(",");
/* 1024 */       _sb_.append(this.last_month_cash_amt);
/* 1025 */       _sb_.append(",");
/* 1026 */       _sb_.append(this.last_cash_amt_refresh_time);
/* 1027 */       _sb_.append(")");
/* 1028 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RecentlyCashInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */