/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class NoneRealTimeRoleLevelRank extends XBean implements xbean.NoneRealTimeRoleLevelRank
/*      */ {
/*      */   private LinkedList<xbean.NoneRealRoleLevelBean> rankdatas;
/*      */   private HashMap<Long, Integer> keytorankchange;
/*      */   private long savetime;
/*      */   private long awardtime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.rankdatas.clear();
/*   25 */     this.keytorankchange.clear();
/*   26 */     this.savetime = 0L;
/*   27 */     this.awardtime = 0L;
/*      */   }
/*      */   
/*      */   NoneRealTimeRoleLevelRank(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.rankdatas = new LinkedList();
/*   34 */     this.keytorankchange = new HashMap();
/*   35 */     this.awardtime = 0L;
/*      */   }
/*      */   
/*      */   public NoneRealTimeRoleLevelRank()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public NoneRealTimeRoleLevelRank(NoneRealTimeRoleLevelRank _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   NoneRealTimeRoleLevelRank(xbean.NoneRealTimeRoleLevelRank _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof NoneRealTimeRoleLevelRank)) { assign((NoneRealTimeRoleLevelRank)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(NoneRealTimeRoleLevelRank _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.rankdatas = new LinkedList();
/*   61 */     for (xbean.NoneRealRoleLevelBean _v_ : _o_.rankdatas)
/*   62 */       this.rankdatas.add(new NoneRealRoleLevelBean(_v_, this, "rankdatas"));
/*   63 */     this.keytorankchange = new HashMap();
/*   64 */     for (Map.Entry<Long, Integer> _e_ : _o_.keytorankchange.entrySet())
/*   65 */       this.keytorankchange.put(_e_.getKey(), _e_.getValue());
/*   66 */     this.savetime = _o_.savetime;
/*   67 */     this.awardtime = _o_.awardtime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   72 */     this.rankdatas = new LinkedList();
/*   73 */     for (xbean.NoneRealRoleLevelBean _v_ : _o_.rankdatas)
/*   74 */       this.rankdatas.add(new NoneRealRoleLevelBean(_v_, this, "rankdatas"));
/*   75 */     this.keytorankchange = new HashMap();
/*   76 */     for (Map.Entry<Long, Integer> _e_ : _o_.keytorankchange.entrySet())
/*   77 */       this.keytorankchange.put(_e_.getKey(), _e_.getValue());
/*   78 */     this.savetime = _o_.savetime;
/*   79 */     this.awardtime = _o_.awardtime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.compact_uint32(this.rankdatas.size());
/*   87 */     for (xbean.NoneRealRoleLevelBean _v_ : this.rankdatas)
/*      */     {
/*   89 */       _v_.marshal(_os_);
/*      */     }
/*   91 */     _os_.compact_uint32(this.keytorankchange.size());
/*   92 */     for (Map.Entry<Long, Integer> _e_ : this.keytorankchange.entrySet())
/*      */     {
/*   94 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   95 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   97 */     _os_.marshal(this.savetime);
/*   98 */     _os_.marshal(this.awardtime);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  108 */       xbean.NoneRealRoleLevelBean _v_ = new NoneRealRoleLevelBean(0, this, "rankdatas");
/*  109 */       _v_.unmarshal(_os_);
/*  110 */       this.rankdatas.add(_v_);
/*      */     }
/*      */     
/*  113 */     int size = _os_.uncompact_uint32();
/*  114 */     if (size >= 12)
/*      */     {
/*  116 */       this.keytorankchange = new HashMap(size * 2);
/*      */     }
/*  118 */     for (; size > 0; size--)
/*      */     {
/*  120 */       long _k_ = 0L;
/*  121 */       _k_ = _os_.unmarshal_long();
/*  122 */       int _v_ = 0;
/*  123 */       _v_ = _os_.unmarshal_int();
/*  124 */       this.keytorankchange.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  127 */     this.savetime = _os_.unmarshal_long();
/*  128 */     this.awardtime = _os_.unmarshal_long();
/*  129 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  135 */     _xdb_verify_unsafe_();
/*  136 */     int _size_ = 0;
/*  137 */     for (xbean.NoneRealRoleLevelBean _v_ : this.rankdatas)
/*      */     {
/*  139 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */     }
/*  141 */     for (Map.Entry<Long, Integer> _e_ : this.keytorankchange.entrySet())
/*      */     {
/*  143 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  144 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  146 */     _size_ += CodedOutputStream.computeInt64Size(3, this.savetime);
/*  147 */     _size_ += CodedOutputStream.computeInt64Size(4, this.awardtime);
/*  148 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  154 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  157 */       for (xbean.NoneRealRoleLevelBean _v_ : this.rankdatas)
/*      */       {
/*  159 */         _output_.writeMessage(1, _v_);
/*      */       }
/*  161 */       for (Map.Entry<Long, Integer> _e_ : this.keytorankchange.entrySet())
/*      */       {
/*  163 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  164 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  166 */       _output_.writeInt64(3, this.savetime);
/*  167 */       _output_.writeInt64(4, this.awardtime);
/*      */     }
/*      */     catch (java.io.IOException e)
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
/*      */         case 10: 
/*  195 */           xbean.NoneRealRoleLevelBean _v_ = new NoneRealRoleLevelBean(0, this, "rankdatas");
/*  196 */           _input_.readMessage(_v_);
/*  197 */           this.rankdatas.add(_v_);
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  202 */           long _k_ = 0L;
/*  203 */           _k_ = _input_.readInt64();
/*  204 */           int readTag = _input_.readTag();
/*  205 */           if (16 != readTag)
/*      */           {
/*  207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  209 */           int _v_ = 0;
/*  210 */           _v_ = _input_.readInt32();
/*  211 */           this.keytorankchange.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  216 */           this.savetime = _input_.readInt64();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  221 */           this.awardtime = _input_.readInt64();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  226 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  228 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  237 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  241 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  243 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.NoneRealTimeRoleLevelRank copy()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return new NoneRealTimeRoleLevelRank(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.NoneRealTimeRoleLevelRank toData()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.NoneRealTimeRoleLevelRank toBean()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new NoneRealTimeRoleLevelRank(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.NoneRealTimeRoleLevelRank toDataIf()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.NoneRealTimeRoleLevelRank toBeanIf()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.NoneRealRoleLevelBean> getRankdatas()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return xdb.Logs.logList(new LogKey(this, "rankdatas"), this.rankdatas);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.NoneRealRoleLevelBean> getRankdatasAsData()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*      */     
/*  299 */     NoneRealTimeRoleLevelRank _o_ = this;
/*  300 */     List<xbean.NoneRealRoleLevelBean> rankdatas = new LinkedList();
/*  301 */     for (xbean.NoneRealRoleLevelBean _v_ : _o_.rankdatas)
/*  302 */       rankdatas.add(new NoneRealRoleLevelBean.Data(_v_));
/*  303 */     return rankdatas;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getKeytorankchange()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return xdb.Logs.logMap(new LogKey(this, "keytorankchange"), this.keytorankchange);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getKeytorankchangeAsData()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*      */     
/*  320 */     NoneRealTimeRoleLevelRank _o_ = this;
/*  321 */     Map<Long, Integer> keytorankchange = new HashMap();
/*  322 */     for (Map.Entry<Long, Integer> _e_ : _o_.keytorankchange.entrySet())
/*  323 */       keytorankchange.put(_e_.getKey(), _e_.getValue());
/*  324 */     return keytorankchange;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSavetime()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return this.savetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAwardtime()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.awardtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSavetime(long _v_)
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     xdb.Logs.logIf(new LogKey(this, "savetime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  352 */         new xdb.logs.LogLong(this, NoneRealTimeRoleLevelRank.this.savetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  356 */             NoneRealTimeRoleLevelRank.this.savetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  360 */     });
/*  361 */     this.savetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAwardtime(long _v_)
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     xdb.Logs.logIf(new LogKey(this, "awardtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  373 */         new xdb.logs.LogLong(this, NoneRealTimeRoleLevelRank.this.awardtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  377 */             NoneRealTimeRoleLevelRank.this.awardtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  381 */     });
/*  382 */     this.awardtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     NoneRealTimeRoleLevelRank _o_ = null;
/*  390 */     if ((_o1_ instanceof NoneRealTimeRoleLevelRank)) { _o_ = (NoneRealTimeRoleLevelRank)_o1_;
/*  391 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  392 */       return false;
/*  393 */     if (!this.rankdatas.equals(_o_.rankdatas)) return false;
/*  394 */     if (!this.keytorankchange.equals(_o_.keytorankchange)) return false;
/*  395 */     if (this.savetime != _o_.savetime) return false;
/*  396 */     if (this.awardtime != _o_.awardtime) return false;
/*  397 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     int _h_ = 0;
/*  405 */     _h_ += this.rankdatas.hashCode();
/*  406 */     _h_ += this.keytorankchange.hashCode();
/*  407 */     _h_ = (int)(_h_ + this.savetime);
/*  408 */     _h_ = (int)(_h_ + this.awardtime);
/*  409 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     StringBuilder _sb_ = new StringBuilder();
/*  417 */     _sb_.append("(");
/*  418 */     _sb_.append(this.rankdatas);
/*  419 */     _sb_.append(",");
/*  420 */     _sb_.append(this.keytorankchange);
/*  421 */     _sb_.append(",");
/*  422 */     _sb_.append(this.savetime);
/*  423 */     _sb_.append(",");
/*  424 */     _sb_.append(this.awardtime);
/*  425 */     _sb_.append(")");
/*  426 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  432 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  433 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rankdatas"));
/*  434 */     lb.add(new xdb.logs.ListenableMap().setVarName("keytorankchange"));
/*  435 */     lb.add(new xdb.logs.ListenableChanged().setVarName("savetime"));
/*  436 */     lb.add(new xdb.logs.ListenableChanged().setVarName("awardtime"));
/*  437 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.NoneRealTimeRoleLevelRank {
/*      */     private Const() {}
/*      */     
/*      */     NoneRealTimeRoleLevelRank nThis() {
/*  444 */       return NoneRealTimeRoleLevelRank.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  450 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.NoneRealTimeRoleLevelRank copy()
/*      */     {
/*  456 */       return NoneRealTimeRoleLevelRank.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.NoneRealTimeRoleLevelRank toData()
/*      */     {
/*  462 */       return NoneRealTimeRoleLevelRank.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.NoneRealTimeRoleLevelRank toBean()
/*      */     {
/*  467 */       return NoneRealTimeRoleLevelRank.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.NoneRealTimeRoleLevelRank toDataIf()
/*      */     {
/*  473 */       return NoneRealTimeRoleLevelRank.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.NoneRealTimeRoleLevelRank toBeanIf()
/*      */     {
/*  478 */       return NoneRealTimeRoleLevelRank.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.NoneRealRoleLevelBean> getRankdatas()
/*      */     {
/*  485 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  486 */       return xdb.Consts.constList(NoneRealTimeRoleLevelRank.this.rankdatas);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.NoneRealRoleLevelBean> getRankdatasAsData()
/*      */     {
/*  492 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*      */       
/*  494 */       NoneRealTimeRoleLevelRank _o_ = NoneRealTimeRoleLevelRank.this;
/*  495 */       List<xbean.NoneRealRoleLevelBean> rankdatas = new LinkedList();
/*  496 */       for (xbean.NoneRealRoleLevelBean _v_ : _o_.rankdatas)
/*  497 */         rankdatas.add(new NoneRealRoleLevelBean.Data(_v_));
/*  498 */       return rankdatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getKeytorankchange()
/*      */     {
/*  505 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  506 */       return xdb.Consts.constMap(NoneRealTimeRoleLevelRank.this.keytorankchange);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getKeytorankchangeAsData()
/*      */     {
/*  513 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*      */       
/*  515 */       NoneRealTimeRoleLevelRank _o_ = NoneRealTimeRoleLevelRank.this;
/*  516 */       Map<Long, Integer> keytorankchange = new HashMap();
/*  517 */       for (Map.Entry<Long, Integer> _e_ : _o_.keytorankchange.entrySet())
/*  518 */         keytorankchange.put(_e_.getKey(), _e_.getValue());
/*  519 */       return keytorankchange;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSavetime()
/*      */     {
/*  526 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  527 */       return NoneRealTimeRoleLevelRank.this.savetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAwardtime()
/*      */     {
/*  534 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  535 */       return NoneRealTimeRoleLevelRank.this.awardtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSavetime(long _v_)
/*      */     {
/*  542 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  543 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardtime(long _v_)
/*      */     {
/*  550 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  551 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  557 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  558 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  564 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  565 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  571 */       return NoneRealTimeRoleLevelRank.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  577 */       return NoneRealTimeRoleLevelRank.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  583 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  584 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  590 */       return NoneRealTimeRoleLevelRank.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  596 */       return NoneRealTimeRoleLevelRank.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  602 */       NoneRealTimeRoleLevelRank.this._xdb_verify_unsafe_();
/*  603 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  609 */       return NoneRealTimeRoleLevelRank.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  615 */       return NoneRealTimeRoleLevelRank.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  621 */       return NoneRealTimeRoleLevelRank.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  627 */       return NoneRealTimeRoleLevelRank.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  633 */       return NoneRealTimeRoleLevelRank.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  639 */       return NoneRealTimeRoleLevelRank.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  645 */       return NoneRealTimeRoleLevelRank.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.NoneRealTimeRoleLevelRank
/*      */   {
/*      */     private LinkedList<xbean.NoneRealRoleLevelBean> rankdatas;
/*      */     
/*      */     private HashMap<Long, Integer> keytorankchange;
/*      */     
/*      */     private long savetime;
/*      */     
/*      */     private long awardtime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  663 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  668 */       this.rankdatas = new LinkedList();
/*  669 */       this.keytorankchange = new HashMap();
/*  670 */       this.awardtime = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.NoneRealTimeRoleLevelRank _o1_)
/*      */     {
/*  675 */       if ((_o1_ instanceof NoneRealTimeRoleLevelRank)) { assign((NoneRealTimeRoleLevelRank)_o1_);
/*  676 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  677 */       } else if ((_o1_ instanceof NoneRealTimeRoleLevelRank.Const)) assign(((NoneRealTimeRoleLevelRank.Const)_o1_).nThis()); else {
/*  678 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(NoneRealTimeRoleLevelRank _o_) {
/*  683 */       this.rankdatas = new LinkedList();
/*  684 */       for (xbean.NoneRealRoleLevelBean _v_ : _o_.rankdatas)
/*  685 */         this.rankdatas.add(new NoneRealRoleLevelBean.Data(_v_));
/*  686 */       this.keytorankchange = new HashMap();
/*  687 */       for (Map.Entry<Long, Integer> _e_ : _o_.keytorankchange.entrySet())
/*  688 */         this.keytorankchange.put(_e_.getKey(), _e_.getValue());
/*  689 */       this.savetime = _o_.savetime;
/*  690 */       this.awardtime = _o_.awardtime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  695 */       this.rankdatas = new LinkedList();
/*  696 */       for (xbean.NoneRealRoleLevelBean _v_ : _o_.rankdatas)
/*  697 */         this.rankdatas.add(new NoneRealRoleLevelBean.Data(_v_));
/*  698 */       this.keytorankchange = new HashMap();
/*  699 */       for (Map.Entry<Long, Integer> _e_ : _o_.keytorankchange.entrySet())
/*  700 */         this.keytorankchange.put(_e_.getKey(), _e_.getValue());
/*  701 */       this.savetime = _o_.savetime;
/*  702 */       this.awardtime = _o_.awardtime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  708 */       _os_.compact_uint32(this.rankdatas.size());
/*  709 */       for (xbean.NoneRealRoleLevelBean _v_ : this.rankdatas)
/*      */       {
/*  711 */         _v_.marshal(_os_);
/*      */       }
/*  713 */       _os_.compact_uint32(this.keytorankchange.size());
/*  714 */       for (Map.Entry<Long, Integer> _e_ : this.keytorankchange.entrySet())
/*      */       {
/*  716 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  717 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  719 */       _os_.marshal(this.savetime);
/*  720 */       _os_.marshal(this.awardtime);
/*  721 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  727 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  729 */         xbean.NoneRealRoleLevelBean _v_ = xbean.Pod.newNoneRealRoleLevelBeanData();
/*  730 */         _v_.unmarshal(_os_);
/*  731 */         this.rankdatas.add(_v_);
/*      */       }
/*      */       
/*  734 */       int size = _os_.uncompact_uint32();
/*  735 */       if (size >= 12)
/*      */       {
/*  737 */         this.keytorankchange = new HashMap(size * 2);
/*      */       }
/*  739 */       for (; size > 0; size--)
/*      */       {
/*  741 */         long _k_ = 0L;
/*  742 */         _k_ = _os_.unmarshal_long();
/*  743 */         int _v_ = 0;
/*  744 */         _v_ = _os_.unmarshal_int();
/*  745 */         this.keytorankchange.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  748 */       this.savetime = _os_.unmarshal_long();
/*  749 */       this.awardtime = _os_.unmarshal_long();
/*  750 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  756 */       int _size_ = 0;
/*  757 */       for (xbean.NoneRealRoleLevelBean _v_ : this.rankdatas)
/*      */       {
/*  759 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */       }
/*  761 */       for (Map.Entry<Long, Integer> _e_ : this.keytorankchange.entrySet())
/*      */       {
/*  763 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  764 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  766 */       _size_ += CodedOutputStream.computeInt64Size(3, this.savetime);
/*  767 */       _size_ += CodedOutputStream.computeInt64Size(4, this.awardtime);
/*  768 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  776 */         for (xbean.NoneRealRoleLevelBean _v_ : this.rankdatas)
/*      */         {
/*  778 */           _output_.writeMessage(1, _v_);
/*      */         }
/*  780 */         for (Map.Entry<Long, Integer> _e_ : this.keytorankchange.entrySet())
/*      */         {
/*  782 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  783 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  785 */         _output_.writeInt64(3, this.savetime);
/*  786 */         _output_.writeInt64(4, this.awardtime);
/*      */       }
/*      */       catch (java.io.IOException e)
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
/*  813 */             xbean.NoneRealRoleLevelBean _v_ = xbean.Pod.newNoneRealRoleLevelBeanData();
/*  814 */             _input_.readMessage(_v_);
/*  815 */             this.rankdatas.add(_v_);
/*  816 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  820 */             long _k_ = 0L;
/*  821 */             _k_ = _input_.readInt64();
/*  822 */             int readTag = _input_.readTag();
/*  823 */             if (16 != readTag)
/*      */             {
/*  825 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  827 */             int _v_ = 0;
/*  828 */             _v_ = _input_.readInt32();
/*  829 */             this.keytorankchange.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  830 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  834 */             this.savetime = _input_.readInt64();
/*  835 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  839 */             this.awardtime = _input_.readInt64();
/*  840 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  844 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  846 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  855 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  859 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  861 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.NoneRealTimeRoleLevelRank copy()
/*      */     {
/*  867 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.NoneRealTimeRoleLevelRank toData()
/*      */     {
/*  873 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.NoneRealTimeRoleLevelRank toBean()
/*      */     {
/*  878 */       return new NoneRealTimeRoleLevelRank(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.NoneRealTimeRoleLevelRank toDataIf()
/*      */     {
/*  884 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.NoneRealTimeRoleLevelRank toBeanIf()
/*      */     {
/*  889 */       return new NoneRealTimeRoleLevelRank(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  895 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  903 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  907 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  911 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  915 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  919 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.NoneRealRoleLevelBean> getRankdatas()
/*      */     {
/*  926 */       return this.rankdatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.NoneRealRoleLevelBean> getRankdatasAsData()
/*      */     {
/*  933 */       return this.rankdatas;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getKeytorankchange()
/*      */     {
/*  940 */       return this.keytorankchange;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getKeytorankchangeAsData()
/*      */     {
/*  947 */       return this.keytorankchange;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSavetime()
/*      */     {
/*  954 */       return this.savetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAwardtime()
/*      */     {
/*  961 */       return this.awardtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSavetime(long _v_)
/*      */     {
/*  968 */       this.savetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAwardtime(long _v_)
/*      */     {
/*  975 */       this.awardtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  981 */       if (!(_o1_ instanceof Data)) return false;
/*  982 */       Data _o_ = (Data)_o1_;
/*  983 */       if (!this.rankdatas.equals(_o_.rankdatas)) return false;
/*  984 */       if (!this.keytorankchange.equals(_o_.keytorankchange)) return false;
/*  985 */       if (this.savetime != _o_.savetime) return false;
/*  986 */       if (this.awardtime != _o_.awardtime) return false;
/*  987 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/*  993 */       int _h_ = 0;
/*  994 */       _h_ += this.rankdatas.hashCode();
/*  995 */       _h_ += this.keytorankchange.hashCode();
/*  996 */       _h_ = (int)(_h_ + this.savetime);
/*  997 */       _h_ = (int)(_h_ + this.awardtime);
/*  998 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1004 */       StringBuilder _sb_ = new StringBuilder();
/* 1005 */       _sb_.append("(");
/* 1006 */       _sb_.append(this.rankdatas);
/* 1007 */       _sb_.append(",");
/* 1008 */       _sb_.append(this.keytorankchange);
/* 1009 */       _sb_.append(",");
/* 1010 */       _sb_.append(this.savetime);
/* 1011 */       _sb_.append(",");
/* 1012 */       _sb_.append(this.awardtime);
/* 1013 */       _sb_.append(")");
/* 1014 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\NoneRealTimeRoleLevelRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */