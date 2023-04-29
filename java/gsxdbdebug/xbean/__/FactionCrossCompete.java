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
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class FactionCrossCompete extends XBean implements xbean.FactionCrossCompete
/*      */ {
/*      */   private long signup_time;
/*      */   private int win_times;
/*      */   private int lose_times;
/*      */   private HashMap<Long, Integer> factionid2matchtimes;
/*      */   private int miss_turn_times;
/*      */   private long opponent;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.signup_time = 0L;
/*   29 */     this.win_times = 0;
/*   30 */     this.lose_times = 0;
/*   31 */     this.factionid2matchtimes.clear();
/*   32 */     this.miss_turn_times = 0;
/*   33 */     this.opponent = 0L;
/*      */   }
/*      */   
/*      */   FactionCrossCompete(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.signup_time = 0L;
/*   40 */     this.win_times = 0;
/*   41 */     this.lose_times = 0;
/*   42 */     this.factionid2matchtimes = new HashMap();
/*      */   }
/*      */   
/*      */   public FactionCrossCompete()
/*      */   {
/*   47 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FactionCrossCompete(FactionCrossCompete _o_)
/*      */   {
/*   52 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FactionCrossCompete(xbean.FactionCrossCompete _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   57 */     super(_xp_, _vn_);
/*   58 */     if ((_o1_ instanceof FactionCrossCompete)) { assign((FactionCrossCompete)_o1_);
/*   59 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   60 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   61 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FactionCrossCompete _o_) {
/*   66 */     _o_._xdb_verify_unsafe_();
/*   67 */     this.signup_time = _o_.signup_time;
/*   68 */     this.win_times = _o_.win_times;
/*   69 */     this.lose_times = _o_.lose_times;
/*   70 */     this.factionid2matchtimes = new HashMap();
/*   71 */     for (Map.Entry<Long, Integer> _e_ : _o_.factionid2matchtimes.entrySet())
/*   72 */       this.factionid2matchtimes.put(_e_.getKey(), _e_.getValue());
/*   73 */     this.miss_turn_times = _o_.miss_turn_times;
/*   74 */     this.opponent = _o_.opponent;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.signup_time = _o_.signup_time;
/*   80 */     this.win_times = _o_.win_times;
/*   81 */     this.lose_times = _o_.lose_times;
/*   82 */     this.factionid2matchtimes = new HashMap();
/*   83 */     for (Map.Entry<Long, Integer> _e_ : _o_.factionid2matchtimes.entrySet())
/*   84 */       this.factionid2matchtimes.put(_e_.getKey(), _e_.getValue());
/*   85 */     this.miss_turn_times = _o_.miss_turn_times;
/*   86 */     this.opponent = _o_.opponent;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   92 */     _xdb_verify_unsafe_();
/*   93 */     _os_.marshal(this.signup_time);
/*   94 */     _os_.marshal(this.win_times);
/*   95 */     _os_.marshal(this.lose_times);
/*   96 */     _os_.compact_uint32(this.factionid2matchtimes.size());
/*   97 */     for (Map.Entry<Long, Integer> _e_ : this.factionid2matchtimes.entrySet())
/*      */     {
/*   99 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  100 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  102 */     _os_.marshal(this.miss_turn_times);
/*  103 */     _os_.marshal(this.opponent);
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     this.signup_time = _os_.unmarshal_long();
/*  112 */     this.win_times = _os_.unmarshal_int();
/*  113 */     this.lose_times = _os_.unmarshal_int();
/*      */     
/*  115 */     int size = _os_.uncompact_uint32();
/*  116 */     if (size >= 12)
/*      */     {
/*  118 */       this.factionid2matchtimes = new HashMap(size * 2);
/*      */     }
/*  120 */     for (; size > 0; size--)
/*      */     {
/*  122 */       long _k_ = 0L;
/*  123 */       _k_ = _os_.unmarshal_long();
/*  124 */       int _v_ = 0;
/*  125 */       _v_ = _os_.unmarshal_int();
/*  126 */       this.factionid2matchtimes.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  129 */     this.miss_turn_times = _os_.unmarshal_int();
/*  130 */     this.opponent = _os_.unmarshal_long();
/*  131 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*  138 */     int _size_ = 0;
/*  139 */     _size_ += CodedOutputStream.computeInt64Size(1, this.signup_time);
/*  140 */     _size_ += CodedOutputStream.computeInt32Size(2, this.win_times);
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(3, this.lose_times);
/*  142 */     for (Map.Entry<Long, Integer> _e_ : this.factionid2matchtimes.entrySet())
/*      */     {
/*  144 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  145 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(5, this.miss_turn_times);
/*  148 */     _size_ += CodedOutputStream.computeInt64Size(6, this.opponent);
/*  149 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  155 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  158 */       _output_.writeInt64(1, this.signup_time);
/*  159 */       _output_.writeInt32(2, this.win_times);
/*  160 */       _output_.writeInt32(3, this.lose_times);
/*  161 */       for (Map.Entry<Long, Integer> _e_ : this.factionid2matchtimes.entrySet())
/*      */       {
/*  163 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  164 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  166 */       _output_.writeInt32(5, this.miss_turn_times);
/*  167 */       _output_.writeInt64(6, this.opponent);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  171 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  173 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  179 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  182 */       boolean done = false;
/*  183 */       while (!done)
/*      */       {
/*  185 */         int tag = _input_.readTag();
/*  186 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  190 */           done = true;
/*  191 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  195 */           this.signup_time = _input_.readInt64();
/*  196 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  200 */           this.win_times = _input_.readInt32();
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  205 */           this.lose_times = _input_.readInt32();
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  210 */           long _k_ = 0L;
/*  211 */           _k_ = _input_.readInt64();
/*  212 */           int readTag = _input_.readTag();
/*  213 */           if (32 != readTag)
/*      */           {
/*  215 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  217 */           int _v_ = 0;
/*  218 */           _v_ = _input_.readInt32();
/*  219 */           this.factionid2matchtimes.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  224 */           this.miss_turn_times = _input_.readInt32();
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  229 */           this.opponent = _input_.readInt64();
/*  230 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  234 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  236 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  245 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  249 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  251 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionCrossCompete copy()
/*      */   {
/*  257 */     _xdb_verify_unsafe_();
/*  258 */     return new FactionCrossCompete(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionCrossCompete toData()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FactionCrossCompete toBean()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return new FactionCrossCompete(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionCrossCompete toDataIf()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FactionCrossCompete toBeanIf()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSignup_time()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return this.signup_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_times()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return this.win_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLose_times()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return this.lose_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getFactionid2matchtimes()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return xdb.Logs.logMap(new LogKey(this, "factionid2matchtimes"), this.factionid2matchtimes);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getFactionid2matchtimesAsData()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*      */     
/*  332 */     FactionCrossCompete _o_ = this;
/*  333 */     Map<Long, Integer> factionid2matchtimes = new HashMap();
/*  334 */     for (Map.Entry<Long, Integer> _e_ : _o_.factionid2matchtimes.entrySet())
/*  335 */       factionid2matchtimes.put(_e_.getKey(), _e_.getValue());
/*  336 */     return factionid2matchtimes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMiss_turn_times()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return this.miss_turn_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOpponent()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return this.opponent;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSignup_time(long _v_)
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     xdb.Logs.logIf(new LogKey(this, "signup_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  364 */         new xdb.logs.LogLong(this, FactionCrossCompete.this.signup_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  368 */             FactionCrossCompete.this.signup_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  372 */     });
/*  373 */     this.signup_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_times(int _v_)
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     xdb.Logs.logIf(new LogKey(this, "win_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  385 */         new LogInt(this, FactionCrossCompete.this.win_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  389 */             FactionCrossCompete.this.win_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  393 */     });
/*  394 */     this.win_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLose_times(int _v_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     xdb.Logs.logIf(new LogKey(this, "lose_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  406 */         new LogInt(this, FactionCrossCompete.this.lose_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  410 */             FactionCrossCompete.this.lose_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  414 */     });
/*  415 */     this.lose_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMiss_turn_times(int _v_)
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     xdb.Logs.logIf(new LogKey(this, "miss_turn_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  427 */         new LogInt(this, FactionCrossCompete.this.miss_turn_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  431 */             FactionCrossCompete.this.miss_turn_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  435 */     });
/*  436 */     this.miss_turn_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOpponent(long _v_)
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     xdb.Logs.logIf(new LogKey(this, "opponent")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  448 */         new xdb.logs.LogLong(this, FactionCrossCompete.this.opponent)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  452 */             FactionCrossCompete.this.opponent = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  456 */     });
/*  457 */     this.opponent = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     FactionCrossCompete _o_ = null;
/*  465 */     if ((_o1_ instanceof FactionCrossCompete)) { _o_ = (FactionCrossCompete)_o1_;
/*  466 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  467 */       return false;
/*  468 */     if (this.signup_time != _o_.signup_time) return false;
/*  469 */     if (this.win_times != _o_.win_times) return false;
/*  470 */     if (this.lose_times != _o_.lose_times) return false;
/*  471 */     if (!this.factionid2matchtimes.equals(_o_.factionid2matchtimes)) return false;
/*  472 */     if (this.miss_turn_times != _o_.miss_turn_times) return false;
/*  473 */     if (this.opponent != _o_.opponent) return false;
/*  474 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     int _h_ = 0;
/*  482 */     _h_ = (int)(_h_ + this.signup_time);
/*  483 */     _h_ += this.win_times;
/*  484 */     _h_ += this.lose_times;
/*  485 */     _h_ += this.factionid2matchtimes.hashCode();
/*  486 */     _h_ += this.miss_turn_times;
/*  487 */     _h_ = (int)(_h_ + this.opponent);
/*  488 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*  495 */     StringBuilder _sb_ = new StringBuilder();
/*  496 */     _sb_.append("(");
/*  497 */     _sb_.append(this.signup_time);
/*  498 */     _sb_.append(",");
/*  499 */     _sb_.append(this.win_times);
/*  500 */     _sb_.append(",");
/*  501 */     _sb_.append(this.lose_times);
/*  502 */     _sb_.append(",");
/*  503 */     _sb_.append(this.factionid2matchtimes);
/*  504 */     _sb_.append(",");
/*  505 */     _sb_.append(this.miss_turn_times);
/*  506 */     _sb_.append(",");
/*  507 */     _sb_.append(this.opponent);
/*  508 */     _sb_.append(")");
/*  509 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  515 */     ListenableBean lb = new ListenableBean();
/*  516 */     lb.add(new ListenableChanged().setVarName("signup_time"));
/*  517 */     lb.add(new ListenableChanged().setVarName("win_times"));
/*  518 */     lb.add(new ListenableChanged().setVarName("lose_times"));
/*  519 */     lb.add(new xdb.logs.ListenableMap().setVarName("factionid2matchtimes"));
/*  520 */     lb.add(new ListenableChanged().setVarName("miss_turn_times"));
/*  521 */     lb.add(new ListenableChanged().setVarName("opponent"));
/*  522 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FactionCrossCompete {
/*      */     private Const() {}
/*      */     
/*      */     FactionCrossCompete nThis() {
/*  529 */       return FactionCrossCompete.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  535 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCrossCompete copy()
/*      */     {
/*  541 */       return FactionCrossCompete.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCrossCompete toData()
/*      */     {
/*  547 */       return FactionCrossCompete.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FactionCrossCompete toBean()
/*      */     {
/*  552 */       return FactionCrossCompete.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCrossCompete toDataIf()
/*      */     {
/*  558 */       return FactionCrossCompete.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FactionCrossCompete toBeanIf()
/*      */     {
/*  563 */       return FactionCrossCompete.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSignup_time()
/*      */     {
/*  570 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  571 */       return FactionCrossCompete.this.signup_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/*  578 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  579 */       return FactionCrossCompete.this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/*  586 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  587 */       return FactionCrossCompete.this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getFactionid2matchtimes()
/*      */     {
/*  594 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  595 */       return xdb.Consts.constMap(FactionCrossCompete.this.factionid2matchtimes);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getFactionid2matchtimesAsData()
/*      */     {
/*  602 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*      */       
/*  604 */       FactionCrossCompete _o_ = FactionCrossCompete.this;
/*  605 */       Map<Long, Integer> factionid2matchtimes = new HashMap();
/*  606 */       for (Map.Entry<Long, Integer> _e_ : _o_.factionid2matchtimes.entrySet())
/*  607 */         factionid2matchtimes.put(_e_.getKey(), _e_.getValue());
/*  608 */       return factionid2matchtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMiss_turn_times()
/*      */     {
/*  615 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  616 */       return FactionCrossCompete.this.miss_turn_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpponent()
/*      */     {
/*  623 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  624 */       return FactionCrossCompete.this.opponent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignup_time(long _v_)
/*      */     {
/*  631 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  632 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/*  639 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  640 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/*  647 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  648 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMiss_turn_times(int _v_)
/*      */     {
/*  655 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  656 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpponent(long _v_)
/*      */     {
/*  663 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  664 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  670 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  671 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  677 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  678 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  684 */       return FactionCrossCompete.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  690 */       return FactionCrossCompete.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  696 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  697 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  703 */       return FactionCrossCompete.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  709 */       return FactionCrossCompete.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  715 */       FactionCrossCompete.this._xdb_verify_unsafe_();
/*  716 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  722 */       return FactionCrossCompete.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  728 */       return FactionCrossCompete.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  734 */       return FactionCrossCompete.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  740 */       return FactionCrossCompete.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  746 */       return FactionCrossCompete.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  752 */       return FactionCrossCompete.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  758 */       return FactionCrossCompete.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FactionCrossCompete
/*      */   {
/*      */     private long signup_time;
/*      */     
/*      */     private int win_times;
/*      */     
/*      */     private int lose_times;
/*      */     
/*      */     private HashMap<Long, Integer> factionid2matchtimes;
/*      */     
/*      */     private int miss_turn_times;
/*      */     
/*      */     private long opponent;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  780 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  785 */       this.signup_time = 0L;
/*  786 */       this.win_times = 0;
/*  787 */       this.lose_times = 0;
/*  788 */       this.factionid2matchtimes = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.FactionCrossCompete _o1_)
/*      */     {
/*  793 */       if ((_o1_ instanceof FactionCrossCompete)) { assign((FactionCrossCompete)_o1_);
/*  794 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  795 */       } else if ((_o1_ instanceof FactionCrossCompete.Const)) assign(((FactionCrossCompete.Const)_o1_).nThis()); else {
/*  796 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FactionCrossCompete _o_) {
/*  801 */       this.signup_time = _o_.signup_time;
/*  802 */       this.win_times = _o_.win_times;
/*  803 */       this.lose_times = _o_.lose_times;
/*  804 */       this.factionid2matchtimes = new HashMap();
/*  805 */       for (Map.Entry<Long, Integer> _e_ : _o_.factionid2matchtimes.entrySet())
/*  806 */         this.factionid2matchtimes.put(_e_.getKey(), _e_.getValue());
/*  807 */       this.miss_turn_times = _o_.miss_turn_times;
/*  808 */       this.opponent = _o_.opponent;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  813 */       this.signup_time = _o_.signup_time;
/*  814 */       this.win_times = _o_.win_times;
/*  815 */       this.lose_times = _o_.lose_times;
/*  816 */       this.factionid2matchtimes = new HashMap();
/*  817 */       for (Map.Entry<Long, Integer> _e_ : _o_.factionid2matchtimes.entrySet())
/*  818 */         this.factionid2matchtimes.put(_e_.getKey(), _e_.getValue());
/*  819 */       this.miss_turn_times = _o_.miss_turn_times;
/*  820 */       this.opponent = _o_.opponent;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  826 */       _os_.marshal(this.signup_time);
/*  827 */       _os_.marshal(this.win_times);
/*  828 */       _os_.marshal(this.lose_times);
/*  829 */       _os_.compact_uint32(this.factionid2matchtimes.size());
/*  830 */       for (Map.Entry<Long, Integer> _e_ : this.factionid2matchtimes.entrySet())
/*      */       {
/*  832 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  833 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  835 */       _os_.marshal(this.miss_turn_times);
/*  836 */       _os_.marshal(this.opponent);
/*  837 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  843 */       this.signup_time = _os_.unmarshal_long();
/*  844 */       this.win_times = _os_.unmarshal_int();
/*  845 */       this.lose_times = _os_.unmarshal_int();
/*      */       
/*  847 */       int size = _os_.uncompact_uint32();
/*  848 */       if (size >= 12)
/*      */       {
/*  850 */         this.factionid2matchtimes = new HashMap(size * 2);
/*      */       }
/*  852 */       for (; size > 0; size--)
/*      */       {
/*  854 */         long _k_ = 0L;
/*  855 */         _k_ = _os_.unmarshal_long();
/*  856 */         int _v_ = 0;
/*  857 */         _v_ = _os_.unmarshal_int();
/*  858 */         this.factionid2matchtimes.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  861 */       this.miss_turn_times = _os_.unmarshal_int();
/*  862 */       this.opponent = _os_.unmarshal_long();
/*  863 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  869 */       int _size_ = 0;
/*  870 */       _size_ += CodedOutputStream.computeInt64Size(1, this.signup_time);
/*  871 */       _size_ += CodedOutputStream.computeInt32Size(2, this.win_times);
/*  872 */       _size_ += CodedOutputStream.computeInt32Size(3, this.lose_times);
/*  873 */       for (Map.Entry<Long, Integer> _e_ : this.factionid2matchtimes.entrySet())
/*      */       {
/*  875 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  876 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  878 */       _size_ += CodedOutputStream.computeInt32Size(5, this.miss_turn_times);
/*  879 */       _size_ += CodedOutputStream.computeInt64Size(6, this.opponent);
/*  880 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  888 */         _output_.writeInt64(1, this.signup_time);
/*  889 */         _output_.writeInt32(2, this.win_times);
/*  890 */         _output_.writeInt32(3, this.lose_times);
/*  891 */         for (Map.Entry<Long, Integer> _e_ : this.factionid2matchtimes.entrySet())
/*      */         {
/*  893 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  894 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  896 */         _output_.writeInt32(5, this.miss_turn_times);
/*  897 */         _output_.writeInt64(6, this.opponent);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  901 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  903 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  911 */         boolean done = false;
/*  912 */         while (!done)
/*      */         {
/*  914 */           int tag = _input_.readTag();
/*  915 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  919 */             done = true;
/*  920 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  924 */             this.signup_time = _input_.readInt64();
/*  925 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  929 */             this.win_times = _input_.readInt32();
/*  930 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  934 */             this.lose_times = _input_.readInt32();
/*  935 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  939 */             long _k_ = 0L;
/*  940 */             _k_ = _input_.readInt64();
/*  941 */             int readTag = _input_.readTag();
/*  942 */             if (32 != readTag)
/*      */             {
/*  944 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  946 */             int _v_ = 0;
/*  947 */             _v_ = _input_.readInt32();
/*  948 */             this.factionid2matchtimes.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  949 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  953 */             this.miss_turn_times = _input_.readInt32();
/*  954 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  958 */             this.opponent = _input_.readInt64();
/*  959 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  963 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  965 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  974 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  978 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  980 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCrossCompete copy()
/*      */     {
/*  986 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCrossCompete toData()
/*      */     {
/*  992 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FactionCrossCompete toBean()
/*      */     {
/*  997 */       return new FactionCrossCompete(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCrossCompete toDataIf()
/*      */     {
/* 1003 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FactionCrossCompete toBeanIf()
/*      */     {
/* 1008 */       return new FactionCrossCompete(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1014 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1018 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1022 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1026 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1030 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1034 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1038 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSignup_time()
/*      */     {
/* 1045 */       return this.signup_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/* 1052 */       return this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/* 1059 */       return this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getFactionid2matchtimes()
/*      */     {
/* 1066 */       return this.factionid2matchtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getFactionid2matchtimesAsData()
/*      */     {
/* 1073 */       return this.factionid2matchtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMiss_turn_times()
/*      */     {
/* 1080 */       return this.miss_turn_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpponent()
/*      */     {
/* 1087 */       return this.opponent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignup_time(long _v_)
/*      */     {
/* 1094 */       this.signup_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/* 1101 */       this.win_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/* 1108 */       this.lose_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMiss_turn_times(int _v_)
/*      */     {
/* 1115 */       this.miss_turn_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpponent(long _v_)
/*      */     {
/* 1122 */       this.opponent = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1128 */       if (!(_o1_ instanceof Data)) return false;
/* 1129 */       Data _o_ = (Data)_o1_;
/* 1130 */       if (this.signup_time != _o_.signup_time) return false;
/* 1131 */       if (this.win_times != _o_.win_times) return false;
/* 1132 */       if (this.lose_times != _o_.lose_times) return false;
/* 1133 */       if (!this.factionid2matchtimes.equals(_o_.factionid2matchtimes)) return false;
/* 1134 */       if (this.miss_turn_times != _o_.miss_turn_times) return false;
/* 1135 */       if (this.opponent != _o_.opponent) return false;
/* 1136 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1142 */       int _h_ = 0;
/* 1143 */       _h_ = (int)(_h_ + this.signup_time);
/* 1144 */       _h_ += this.win_times;
/* 1145 */       _h_ += this.lose_times;
/* 1146 */       _h_ += this.factionid2matchtimes.hashCode();
/* 1147 */       _h_ += this.miss_turn_times;
/* 1148 */       _h_ = (int)(_h_ + this.opponent);
/* 1149 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1155 */       StringBuilder _sb_ = new StringBuilder();
/* 1156 */       _sb_.append("(");
/* 1157 */       _sb_.append(this.signup_time);
/* 1158 */       _sb_.append(",");
/* 1159 */       _sb_.append(this.win_times);
/* 1160 */       _sb_.append(",");
/* 1161 */       _sb_.append(this.lose_times);
/* 1162 */       _sb_.append(",");
/* 1163 */       _sb_.append(this.factionid2matchtimes);
/* 1164 */       _sb_.append(",");
/* 1165 */       _sb_.append(this.miss_turn_times);
/* 1166 */       _sb_.append(",");
/* 1167 */       _sb_.append(this.opponent);
/* 1168 */       _sb_.append(")");
/* 1169 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FactionCrossCompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */