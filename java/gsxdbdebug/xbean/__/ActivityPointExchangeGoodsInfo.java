/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class ActivityPointExchangeGoodsInfo extends XBean implements xbean.ActivityPointExchangeGoodsInfo
/*      */ {
/*      */   private HashMap<Integer, Integer> goodscfgid2count;
/*      */   private int manualrefreshcount;
/*      */   private long manualrefreshcountresettimestamp;
/*      */   private long exchangecountresettimestamp;
/*      */   private boolean isneedrefresh;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.goodscfgid2count.clear();
/*   27 */     this.manualrefreshcount = 0;
/*   28 */     this.manualrefreshcountresettimestamp = 0L;
/*   29 */     this.exchangecountresettimestamp = 0L;
/*   30 */     this.isneedrefresh = false;
/*      */   }
/*      */   
/*      */   ActivityPointExchangeGoodsInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.goodscfgid2count = new HashMap();
/*      */   }
/*      */   
/*      */   public ActivityPointExchangeGoodsInfo()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ActivityPointExchangeGoodsInfo(ActivityPointExchangeGoodsInfo _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ActivityPointExchangeGoodsInfo(xbean.ActivityPointExchangeGoodsInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof ActivityPointExchangeGoodsInfo)) { assign((ActivityPointExchangeGoodsInfo)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ActivityPointExchangeGoodsInfo _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.goodscfgid2count = new HashMap();
/*   62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goodscfgid2count.entrySet())
/*   63 */       this.goodscfgid2count.put(_e_.getKey(), _e_.getValue());
/*   64 */     this.manualrefreshcount = _o_.manualrefreshcount;
/*   65 */     this.manualrefreshcountresettimestamp = _o_.manualrefreshcountresettimestamp;
/*   66 */     this.exchangecountresettimestamp = _o_.exchangecountresettimestamp;
/*   67 */     this.isneedrefresh = _o_.isneedrefresh;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   72 */     this.goodscfgid2count = new HashMap();
/*   73 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goodscfgid2count.entrySet())
/*   74 */       this.goodscfgid2count.put(_e_.getKey(), _e_.getValue());
/*   75 */     this.manualrefreshcount = _o_.manualrefreshcount;
/*   76 */     this.manualrefreshcountresettimestamp = _o_.manualrefreshcountresettimestamp;
/*   77 */     this.exchangecountresettimestamp = _o_.exchangecountresettimestamp;
/*   78 */     this.isneedrefresh = _o_.isneedrefresh;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.compact_uint32(this.goodscfgid2count.size());
/*   86 */     for (Map.Entry<Integer, Integer> _e_ : this.goodscfgid2count.entrySet())
/*      */     {
/*   88 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   89 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   91 */     _os_.marshal(this.manualrefreshcount);
/*   92 */     _os_.marshal(this.manualrefreshcountresettimestamp);
/*   93 */     _os_.marshal(this.exchangecountresettimestamp);
/*   94 */     _os_.marshal(this.isneedrefresh);
/*   95 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*      */     
/*  103 */     int size = _os_.uncompact_uint32();
/*  104 */     if (size >= 12)
/*      */     {
/*  106 */       this.goodscfgid2count = new HashMap(size * 2);
/*      */     }
/*  108 */     for (; size > 0; size--)
/*      */     {
/*  110 */       int _k_ = 0;
/*  111 */       _k_ = _os_.unmarshal_int();
/*  112 */       int _v_ = 0;
/*  113 */       _v_ = _os_.unmarshal_int();
/*  114 */       this.goodscfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  117 */     this.manualrefreshcount = _os_.unmarshal_int();
/*  118 */     this.manualrefreshcountresettimestamp = _os_.unmarshal_long();
/*  119 */     this.exchangecountresettimestamp = _os_.unmarshal_long();
/*  120 */     this.isneedrefresh = _os_.unmarshal_boolean();
/*  121 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  127 */     _xdb_verify_unsafe_();
/*  128 */     int _size_ = 0;
/*  129 */     for (Map.Entry<Integer, Integer> _e_ : this.goodscfgid2count.entrySet())
/*      */     {
/*  131 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  132 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  134 */     _size_ += CodedOutputStream.computeInt32Size(2, this.manualrefreshcount);
/*  135 */     _size_ += CodedOutputStream.computeInt64Size(3, this.manualrefreshcountresettimestamp);
/*  136 */     _size_ += CodedOutputStream.computeInt64Size(4, this.exchangecountresettimestamp);
/*  137 */     _size_ += CodedOutputStream.computeBoolSize(5, this.isneedrefresh);
/*  138 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       for (Map.Entry<Integer, Integer> _e_ : this.goodscfgid2count.entrySet())
/*      */       {
/*  149 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  150 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  152 */       _output_.writeInt32(2, this.manualrefreshcount);
/*  153 */       _output_.writeInt64(3, this.manualrefreshcountresettimestamp);
/*  154 */       _output_.writeInt64(4, this.exchangecountresettimestamp);
/*  155 */       _output_.writeBool(5, this.isneedrefresh);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  159 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  161 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  167 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  170 */       boolean done = false;
/*  171 */       while (!done)
/*      */       {
/*  173 */         int tag = _input_.readTag();
/*  174 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  178 */           done = true;
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  183 */           int _k_ = 0;
/*  184 */           _k_ = _input_.readInt32();
/*  185 */           int readTag = _input_.readTag();
/*  186 */           if (8 != readTag)
/*      */           {
/*  188 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  190 */           int _v_ = 0;
/*  191 */           _v_ = _input_.readInt32();
/*  192 */           this.goodscfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  197 */           this.manualrefreshcount = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  202 */           this.manualrefreshcountresettimestamp = _input_.readInt64();
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  207 */           this.exchangecountresettimestamp = _input_.readInt64();
/*  208 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  212 */           this.isneedrefresh = _input_.readBool();
/*  213 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  217 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  219 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  228 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  232 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  234 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ActivityPointExchangeGoodsInfo copy()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return new ActivityPointExchangeGoodsInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ActivityPointExchangeGoodsInfo toData()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ActivityPointExchangeGoodsInfo toBean()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return new ActivityPointExchangeGoodsInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ActivityPointExchangeGoodsInfo toDataIf()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ActivityPointExchangeGoodsInfo toBeanIf()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getGoodscfgid2count()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return xdb.Logs.logMap(new LogKey(this, "goodscfgid2count"), this.goodscfgid2count);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getGoodscfgid2countAsData()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*      */     
/*  291 */     ActivityPointExchangeGoodsInfo _o_ = this;
/*  292 */     Map<Integer, Integer> goodscfgid2count = new HashMap();
/*  293 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goodscfgid2count.entrySet())
/*  294 */       goodscfgid2count.put(_e_.getKey(), _e_.getValue());
/*  295 */     return goodscfgid2count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getManualrefreshcount()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return this.manualrefreshcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getManualrefreshcountresettimestamp()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.manualrefreshcountresettimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getExchangecountresettimestamp()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.exchangecountresettimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIsneedrefresh()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.isneedrefresh;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setManualrefreshcount(int _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     xdb.Logs.logIf(new LogKey(this, "manualrefreshcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  339 */         new xdb.logs.LogInt(this, ActivityPointExchangeGoodsInfo.this.manualrefreshcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  343 */             ActivityPointExchangeGoodsInfo.this.manualrefreshcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  347 */     });
/*  348 */     this.manualrefreshcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setManualrefreshcountresettimestamp(long _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     xdb.Logs.logIf(new LogKey(this, "manualrefreshcountresettimestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  360 */         new xdb.logs.LogLong(this, ActivityPointExchangeGoodsInfo.this.manualrefreshcountresettimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             ActivityPointExchangeGoodsInfo.this.manualrefreshcountresettimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.manualrefreshcountresettimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExchangecountresettimestamp(long _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     xdb.Logs.logIf(new LogKey(this, "exchangecountresettimestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  381 */         new xdb.logs.LogLong(this, ActivityPointExchangeGoodsInfo.this.exchangecountresettimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             ActivityPointExchangeGoodsInfo.this.exchangecountresettimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.exchangecountresettimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsneedrefresh(boolean _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     xdb.Logs.logIf(new LogKey(this, "isneedrefresh")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  402 */         new xdb.logs.LogObject(this, Boolean.valueOf(ActivityPointExchangeGoodsInfo.this.isneedrefresh))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             ActivityPointExchangeGoodsInfo.this.isneedrefresh = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.isneedrefresh = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     ActivityPointExchangeGoodsInfo _o_ = null;
/*  419 */     if ((_o1_ instanceof ActivityPointExchangeGoodsInfo)) { _o_ = (ActivityPointExchangeGoodsInfo)_o1_;
/*  420 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  421 */       return false;
/*  422 */     if (!this.goodscfgid2count.equals(_o_.goodscfgid2count)) return false;
/*  423 */     if (this.manualrefreshcount != _o_.manualrefreshcount) return false;
/*  424 */     if (this.manualrefreshcountresettimestamp != _o_.manualrefreshcountresettimestamp) return false;
/*  425 */     if (this.exchangecountresettimestamp != _o_.exchangecountresettimestamp) return false;
/*  426 */     if (this.isneedrefresh != _o_.isneedrefresh) return false;
/*  427 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     int _h_ = 0;
/*  435 */     _h_ += this.goodscfgid2count.hashCode();
/*  436 */     _h_ += this.manualrefreshcount;
/*  437 */     _h_ = (int)(_h_ + this.manualrefreshcountresettimestamp);
/*  438 */     _h_ = (int)(_h_ + this.exchangecountresettimestamp);
/*  439 */     _h_ += (this.isneedrefresh ? 1231 : 1237);
/*  440 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     StringBuilder _sb_ = new StringBuilder();
/*  448 */     _sb_.append("(");
/*  449 */     _sb_.append(this.goodscfgid2count);
/*  450 */     _sb_.append(",");
/*  451 */     _sb_.append(this.manualrefreshcount);
/*  452 */     _sb_.append(",");
/*  453 */     _sb_.append(this.manualrefreshcountresettimestamp);
/*  454 */     _sb_.append(",");
/*  455 */     _sb_.append(this.exchangecountresettimestamp);
/*  456 */     _sb_.append(",");
/*  457 */     _sb_.append(this.isneedrefresh);
/*  458 */     _sb_.append(")");
/*  459 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  465 */     ListenableBean lb = new ListenableBean();
/*  466 */     lb.add(new xdb.logs.ListenableMap().setVarName("goodscfgid2count"));
/*  467 */     lb.add(new ListenableChanged().setVarName("manualrefreshcount"));
/*  468 */     lb.add(new ListenableChanged().setVarName("manualrefreshcountresettimestamp"));
/*  469 */     lb.add(new ListenableChanged().setVarName("exchangecountresettimestamp"));
/*  470 */     lb.add(new ListenableChanged().setVarName("isneedrefresh"));
/*  471 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ActivityPointExchangeGoodsInfo {
/*      */     private Const() {}
/*      */     
/*      */     ActivityPointExchangeGoodsInfo nThis() {
/*  478 */       return ActivityPointExchangeGoodsInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  484 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityPointExchangeGoodsInfo copy()
/*      */     {
/*  490 */       return ActivityPointExchangeGoodsInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityPointExchangeGoodsInfo toData()
/*      */     {
/*  496 */       return ActivityPointExchangeGoodsInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ActivityPointExchangeGoodsInfo toBean()
/*      */     {
/*  501 */       return ActivityPointExchangeGoodsInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityPointExchangeGoodsInfo toDataIf()
/*      */     {
/*  507 */       return ActivityPointExchangeGoodsInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ActivityPointExchangeGoodsInfo toBeanIf()
/*      */     {
/*  512 */       return ActivityPointExchangeGoodsInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoodscfgid2count()
/*      */     {
/*  519 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  520 */       return xdb.Consts.constMap(ActivityPointExchangeGoodsInfo.this.goodscfgid2count);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoodscfgid2countAsData()
/*      */     {
/*  527 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*      */       
/*  529 */       ActivityPointExchangeGoodsInfo _o_ = ActivityPointExchangeGoodsInfo.this;
/*  530 */       Map<Integer, Integer> goodscfgid2count = new HashMap();
/*  531 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goodscfgid2count.entrySet())
/*  532 */         goodscfgid2count.put(_e_.getKey(), _e_.getValue());
/*  533 */       return goodscfgid2count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getManualrefreshcount()
/*      */     {
/*  540 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  541 */       return ActivityPointExchangeGoodsInfo.this.manualrefreshcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getManualrefreshcountresettimestamp()
/*      */     {
/*  548 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  549 */       return ActivityPointExchangeGoodsInfo.this.manualrefreshcountresettimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExchangecountresettimestamp()
/*      */     {
/*  556 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  557 */       return ActivityPointExchangeGoodsInfo.this.exchangecountresettimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsneedrefresh()
/*      */     {
/*  564 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  565 */       return ActivityPointExchangeGoodsInfo.this.isneedrefresh;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setManualrefreshcount(int _v_)
/*      */     {
/*  572 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setManualrefreshcountresettimestamp(long _v_)
/*      */     {
/*  580 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  581 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExchangecountresettimestamp(long _v_)
/*      */     {
/*  588 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  589 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsneedrefresh(boolean _v_)
/*      */     {
/*  596 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  597 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  603 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  604 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  610 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  611 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  617 */       return ActivityPointExchangeGoodsInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  623 */       return ActivityPointExchangeGoodsInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  629 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  636 */       return ActivityPointExchangeGoodsInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  642 */       return ActivityPointExchangeGoodsInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  648 */       ActivityPointExchangeGoodsInfo.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  655 */       return ActivityPointExchangeGoodsInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  661 */       return ActivityPointExchangeGoodsInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  667 */       return ActivityPointExchangeGoodsInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  673 */       return ActivityPointExchangeGoodsInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  679 */       return ActivityPointExchangeGoodsInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  685 */       return ActivityPointExchangeGoodsInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  691 */       return ActivityPointExchangeGoodsInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ActivityPointExchangeGoodsInfo
/*      */   {
/*      */     private HashMap<Integer, Integer> goodscfgid2count;
/*      */     
/*      */     private int manualrefreshcount;
/*      */     
/*      */     private long manualrefreshcountresettimestamp;
/*      */     
/*      */     private long exchangecountresettimestamp;
/*      */     
/*      */     private boolean isneedrefresh;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  716 */       this.goodscfgid2count = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.ActivityPointExchangeGoodsInfo _o1_)
/*      */     {
/*  721 */       if ((_o1_ instanceof ActivityPointExchangeGoodsInfo)) { assign((ActivityPointExchangeGoodsInfo)_o1_);
/*  722 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  723 */       } else if ((_o1_ instanceof ActivityPointExchangeGoodsInfo.Const)) assign(((ActivityPointExchangeGoodsInfo.Const)_o1_).nThis()); else {
/*  724 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ActivityPointExchangeGoodsInfo _o_) {
/*  729 */       this.goodscfgid2count = new HashMap();
/*  730 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goodscfgid2count.entrySet())
/*  731 */         this.goodscfgid2count.put(_e_.getKey(), _e_.getValue());
/*  732 */       this.manualrefreshcount = _o_.manualrefreshcount;
/*  733 */       this.manualrefreshcountresettimestamp = _o_.manualrefreshcountresettimestamp;
/*  734 */       this.exchangecountresettimestamp = _o_.exchangecountresettimestamp;
/*  735 */       this.isneedrefresh = _o_.isneedrefresh;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  740 */       this.goodscfgid2count = new HashMap();
/*  741 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goodscfgid2count.entrySet())
/*  742 */         this.goodscfgid2count.put(_e_.getKey(), _e_.getValue());
/*  743 */       this.manualrefreshcount = _o_.manualrefreshcount;
/*  744 */       this.manualrefreshcountresettimestamp = _o_.manualrefreshcountresettimestamp;
/*  745 */       this.exchangecountresettimestamp = _o_.exchangecountresettimestamp;
/*  746 */       this.isneedrefresh = _o_.isneedrefresh;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  752 */       _os_.compact_uint32(this.goodscfgid2count.size());
/*  753 */       for (Map.Entry<Integer, Integer> _e_ : this.goodscfgid2count.entrySet())
/*      */       {
/*  755 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  756 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  758 */       _os_.marshal(this.manualrefreshcount);
/*  759 */       _os_.marshal(this.manualrefreshcountresettimestamp);
/*  760 */       _os_.marshal(this.exchangecountresettimestamp);
/*  761 */       _os_.marshal(this.isneedrefresh);
/*  762 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  769 */       int size = _os_.uncompact_uint32();
/*  770 */       if (size >= 12)
/*      */       {
/*  772 */         this.goodscfgid2count = new HashMap(size * 2);
/*      */       }
/*  774 */       for (; size > 0; size--)
/*      */       {
/*  776 */         int _k_ = 0;
/*  777 */         _k_ = _os_.unmarshal_int();
/*  778 */         int _v_ = 0;
/*  779 */         _v_ = _os_.unmarshal_int();
/*  780 */         this.goodscfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  783 */       this.manualrefreshcount = _os_.unmarshal_int();
/*  784 */       this.manualrefreshcountresettimestamp = _os_.unmarshal_long();
/*  785 */       this.exchangecountresettimestamp = _os_.unmarshal_long();
/*  786 */       this.isneedrefresh = _os_.unmarshal_boolean();
/*  787 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  793 */       int _size_ = 0;
/*  794 */       for (Map.Entry<Integer, Integer> _e_ : this.goodscfgid2count.entrySet())
/*      */       {
/*  796 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  797 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  799 */       _size_ += CodedOutputStream.computeInt32Size(2, this.manualrefreshcount);
/*  800 */       _size_ += CodedOutputStream.computeInt64Size(3, this.manualrefreshcountresettimestamp);
/*  801 */       _size_ += CodedOutputStream.computeInt64Size(4, this.exchangecountresettimestamp);
/*  802 */       _size_ += CodedOutputStream.computeBoolSize(5, this.isneedrefresh);
/*  803 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  811 */         for (Map.Entry<Integer, Integer> _e_ : this.goodscfgid2count.entrySet())
/*      */         {
/*  813 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  814 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  816 */         _output_.writeInt32(2, this.manualrefreshcount);
/*  817 */         _output_.writeInt64(3, this.manualrefreshcountresettimestamp);
/*  818 */         _output_.writeInt64(4, this.exchangecountresettimestamp);
/*  819 */         _output_.writeBool(5, this.isneedrefresh);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  823 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  825 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  833 */         boolean done = false;
/*  834 */         while (!done)
/*      */         {
/*  836 */           int tag = _input_.readTag();
/*  837 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  841 */             done = true;
/*  842 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  846 */             int _k_ = 0;
/*  847 */             _k_ = _input_.readInt32();
/*  848 */             int readTag = _input_.readTag();
/*  849 */             if (8 != readTag)
/*      */             {
/*  851 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  853 */             int _v_ = 0;
/*  854 */             _v_ = _input_.readInt32();
/*  855 */             this.goodscfgid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  856 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  860 */             this.manualrefreshcount = _input_.readInt32();
/*  861 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  865 */             this.manualrefreshcountresettimestamp = _input_.readInt64();
/*  866 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  870 */             this.exchangecountresettimestamp = _input_.readInt64();
/*  871 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  875 */             this.isneedrefresh = _input_.readBool();
/*  876 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  880 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  882 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  891 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  895 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  897 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityPointExchangeGoodsInfo copy()
/*      */     {
/*  903 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityPointExchangeGoodsInfo toData()
/*      */     {
/*  909 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ActivityPointExchangeGoodsInfo toBean()
/*      */     {
/*  914 */       return new ActivityPointExchangeGoodsInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ActivityPointExchangeGoodsInfo toDataIf()
/*      */     {
/*  920 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ActivityPointExchangeGoodsInfo toBeanIf()
/*      */     {
/*  925 */       return new ActivityPointExchangeGoodsInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  931 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  935 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  951 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  955 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoodscfgid2count()
/*      */     {
/*  962 */       return this.goodscfgid2count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoodscfgid2countAsData()
/*      */     {
/*  969 */       return this.goodscfgid2count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getManualrefreshcount()
/*      */     {
/*  976 */       return this.manualrefreshcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getManualrefreshcountresettimestamp()
/*      */     {
/*  983 */       return this.manualrefreshcountresettimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExchangecountresettimestamp()
/*      */     {
/*  990 */       return this.exchangecountresettimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsneedrefresh()
/*      */     {
/*  997 */       return this.isneedrefresh;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setManualrefreshcount(int _v_)
/*      */     {
/* 1004 */       this.manualrefreshcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setManualrefreshcountresettimestamp(long _v_)
/*      */     {
/* 1011 */       this.manualrefreshcountresettimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExchangecountresettimestamp(long _v_)
/*      */     {
/* 1018 */       this.exchangecountresettimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsneedrefresh(boolean _v_)
/*      */     {
/* 1025 */       this.isneedrefresh = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1031 */       if (!(_o1_ instanceof Data)) return false;
/* 1032 */       Data _o_ = (Data)_o1_;
/* 1033 */       if (!this.goodscfgid2count.equals(_o_.goodscfgid2count)) return false;
/* 1034 */       if (this.manualrefreshcount != _o_.manualrefreshcount) return false;
/* 1035 */       if (this.manualrefreshcountresettimestamp != _o_.manualrefreshcountresettimestamp) return false;
/* 1036 */       if (this.exchangecountresettimestamp != _o_.exchangecountresettimestamp) return false;
/* 1037 */       if (this.isneedrefresh != _o_.isneedrefresh) return false;
/* 1038 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1044 */       int _h_ = 0;
/* 1045 */       _h_ += this.goodscfgid2count.hashCode();
/* 1046 */       _h_ += this.manualrefreshcount;
/* 1047 */       _h_ = (int)(_h_ + this.manualrefreshcountresettimestamp);
/* 1048 */       _h_ = (int)(_h_ + this.exchangecountresettimestamp);
/* 1049 */       _h_ += (this.isneedrefresh ? 1231 : 1237);
/* 1050 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1056 */       StringBuilder _sb_ = new StringBuilder();
/* 1057 */       _sb_.append("(");
/* 1058 */       _sb_.append(this.goodscfgid2count);
/* 1059 */       _sb_.append(",");
/* 1060 */       _sb_.append(this.manualrefreshcount);
/* 1061 */       _sb_.append(",");
/* 1062 */       _sb_.append(this.manualrefreshcountresettimestamp);
/* 1063 */       _sb_.append(",");
/* 1064 */       _sb_.append(this.exchangecountresettimestamp);
/* 1065 */       _sb_.append(",");
/* 1066 */       _sb_.append(this.isneedrefresh);
/* 1067 */       _sb_.append(")");
/* 1068 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ActivityPointExchangeGoodsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */