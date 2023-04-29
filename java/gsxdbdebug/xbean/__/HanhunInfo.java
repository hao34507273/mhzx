/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class HanhunInfo extends XBean implements xbean.HanhunInfo
/*      */ {
/*      */   private HashMap<Integer, xbean.ItemInfo> iteminfos;
/*      */   private int status;
/*      */   private int seekhelpleftcount;
/*      */   private int helpotherleftcount;
/*      */   private ArrayList<Long> guyshelpyou;
/*      */   private long timeout;
/*      */   private HashMap<Integer, xbean.ItemInfo> iteminfosnext;
/*      */   private boolean alreadygettask;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.iteminfos.clear();
/*   33 */     this.status = 0;
/*   34 */     this.seekhelpleftcount = 0;
/*   35 */     this.helpotherleftcount = 0;
/*   36 */     this.guyshelpyou.clear();
/*   37 */     this.timeout = 0L;
/*   38 */     this.iteminfosnext.clear();
/*   39 */     this.alreadygettask = false;
/*      */   }
/*      */   
/*      */   HanhunInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.iteminfos = new HashMap();
/*   46 */     this.guyshelpyou = new ArrayList();
/*   47 */     this.iteminfosnext = new HashMap();
/*   48 */     this.alreadygettask = false;
/*      */   }
/*      */   
/*      */   public HanhunInfo()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public HanhunInfo(HanhunInfo _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   HanhunInfo(xbean.HanhunInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof HanhunInfo)) { assign((HanhunInfo)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(HanhunInfo _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.iteminfos = new HashMap();
/*   74 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfos.entrySet())
/*   75 */       this.iteminfos.put(_e_.getKey(), new ItemInfo((xbean.ItemInfo)_e_.getValue(), this, "iteminfos"));
/*   76 */     this.status = _o_.status;
/*   77 */     this.seekhelpleftcount = _o_.seekhelpleftcount;
/*   78 */     this.helpotherleftcount = _o_.helpotherleftcount;
/*   79 */     this.guyshelpyou = new ArrayList();
/*   80 */     this.guyshelpyou.addAll(_o_.guyshelpyou);
/*   81 */     this.timeout = _o_.timeout;
/*   82 */     this.iteminfosnext = new HashMap();
/*   83 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfosnext.entrySet())
/*   84 */       this.iteminfosnext.put(_e_.getKey(), new ItemInfo((xbean.ItemInfo)_e_.getValue(), this, "iteminfosnext"));
/*   85 */     this.alreadygettask = _o_.alreadygettask;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   90 */     this.iteminfos = new HashMap();
/*   91 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfos.entrySet())
/*   92 */       this.iteminfos.put(_e_.getKey(), new ItemInfo((xbean.ItemInfo)_e_.getValue(), this, "iteminfos"));
/*   93 */     this.status = _o_.status;
/*   94 */     this.seekhelpleftcount = _o_.seekhelpleftcount;
/*   95 */     this.helpotherleftcount = _o_.helpotherleftcount;
/*   96 */     this.guyshelpyou = new ArrayList();
/*   97 */     this.guyshelpyou.addAll(_o_.guyshelpyou);
/*   98 */     this.timeout = _o_.timeout;
/*   99 */     this.iteminfosnext = new HashMap();
/*  100 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfosnext.entrySet())
/*  101 */       this.iteminfosnext.put(_e_.getKey(), new ItemInfo((xbean.ItemInfo)_e_.getValue(), this, "iteminfosnext"));
/*  102 */     this.alreadygettask = _o_.alreadygettask;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  108 */     _xdb_verify_unsafe_();
/*  109 */     _os_.compact_uint32(this.iteminfos.size());
/*  110 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfos.entrySet())
/*      */     {
/*  112 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  113 */       ((xbean.ItemInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  115 */     _os_.marshal(this.status);
/*  116 */     _os_.marshal(this.seekhelpleftcount);
/*  117 */     _os_.marshal(this.helpotherleftcount);
/*  118 */     _os_.compact_uint32(this.guyshelpyou.size());
/*  119 */     for (Long _v_ : this.guyshelpyou)
/*      */     {
/*  121 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  123 */     _os_.marshal(this.timeout);
/*  124 */     _os_.compact_uint32(this.iteminfosnext.size());
/*  125 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfosnext.entrySet())
/*      */     {
/*  127 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  128 */       ((xbean.ItemInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  130 */     _os_.marshal(this.alreadygettask);
/*  131 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*      */     
/*  139 */     int size = _os_.uncompact_uint32();
/*  140 */     if (size >= 12)
/*      */     {
/*  142 */       this.iteminfos = new HashMap(size * 2);
/*      */     }
/*  144 */     for (; size > 0; size--)
/*      */     {
/*  146 */       int _k_ = 0;
/*  147 */       _k_ = _os_.unmarshal_int();
/*  148 */       xbean.ItemInfo _v_ = new ItemInfo(0, this, "iteminfos");
/*  149 */       _v_.unmarshal(_os_);
/*  150 */       this.iteminfos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  153 */     this.status = _os_.unmarshal_int();
/*  154 */     this.seekhelpleftcount = _os_.unmarshal_int();
/*  155 */     this.helpotherleftcount = _os_.unmarshal_int();
/*  156 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  158 */       long _v_ = 0L;
/*  159 */       _v_ = _os_.unmarshal_long();
/*  160 */       this.guyshelpyou.add(Long.valueOf(_v_));
/*      */     }
/*  162 */     this.timeout = _os_.unmarshal_long();
/*      */     
/*  164 */     int size = _os_.uncompact_uint32();
/*  165 */     if (size >= 12)
/*      */     {
/*  167 */       this.iteminfosnext = new HashMap(size * 2);
/*      */     }
/*  169 */     for (; size > 0; size--)
/*      */     {
/*  171 */       int _k_ = 0;
/*  172 */       _k_ = _os_.unmarshal_int();
/*  173 */       xbean.ItemInfo _v_ = new ItemInfo(0, this, "iteminfosnext");
/*  174 */       _v_.unmarshal(_os_);
/*  175 */       this.iteminfosnext.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  178 */     this.alreadygettask = _os_.unmarshal_boolean();
/*  179 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  185 */     _xdb_verify_unsafe_();
/*  186 */     int _size_ = 0;
/*  187 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfos.entrySet())
/*      */     {
/*  189 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  190 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  192 */     _size_ += CodedOutputStream.computeInt32Size(2, this.status);
/*  193 */     _size_ += CodedOutputStream.computeInt32Size(3, this.seekhelpleftcount);
/*  194 */     _size_ += CodedOutputStream.computeInt32Size(4, this.helpotherleftcount);
/*  195 */     for (Long _v_ : this.guyshelpyou)
/*      */     {
/*  197 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  199 */     _size_ += CodedOutputStream.computeInt64Size(6, this.timeout);
/*  200 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfosnext.entrySet())
/*      */     {
/*  202 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/*  203 */       _size_ += CodedOutputStream.computeMessageSize(7, (Message)_e_.getValue());
/*      */     }
/*  205 */     _size_ += CodedOutputStream.computeBoolSize(8, this.alreadygettask);
/*  206 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  212 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  215 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfos.entrySet())
/*      */       {
/*  217 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  218 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  220 */       _output_.writeInt32(2, this.status);
/*  221 */       _output_.writeInt32(3, this.seekhelpleftcount);
/*  222 */       _output_.writeInt32(4, this.helpotherleftcount);
/*  223 */       for (Long _v_ : this.guyshelpyou)
/*      */       {
/*  225 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  227 */       _output_.writeInt64(6, this.timeout);
/*  228 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfosnext.entrySet())
/*      */       {
/*  230 */         _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/*  231 */         _output_.writeMessage(7, (Message)_e_.getValue());
/*      */       }
/*  233 */       _output_.writeBool(8, this.alreadygettask);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  237 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  239 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  248 */       boolean done = false;
/*  249 */       while (!done)
/*      */       {
/*  251 */         int tag = _input_.readTag();
/*  252 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  256 */           done = true;
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  261 */           int _k_ = 0;
/*  262 */           _k_ = _input_.readInt32();
/*  263 */           int readTag = _input_.readTag();
/*  264 */           if (10 != readTag)
/*      */           {
/*  266 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  268 */           xbean.ItemInfo _v_ = new ItemInfo(0, this, "iteminfos");
/*  269 */           _input_.readMessage(_v_);
/*  270 */           this.iteminfos.put(Integer.valueOf(_k_), _v_);
/*  271 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  275 */           this.status = _input_.readInt32();
/*  276 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  280 */           this.seekhelpleftcount = _input_.readInt32();
/*  281 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  285 */           this.helpotherleftcount = _input_.readInt32();
/*  286 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  290 */           long _v_ = 0L;
/*  291 */           _v_ = _input_.readInt64();
/*  292 */           this.guyshelpyou.add(Long.valueOf(_v_));
/*  293 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  297 */           this.timeout = _input_.readInt64();
/*  298 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  302 */           int _k_ = 0;
/*  303 */           _k_ = _input_.readInt32();
/*  304 */           int readTag = _input_.readTag();
/*  305 */           if (58 != readTag)
/*      */           {
/*  307 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  309 */           xbean.ItemInfo _v_ = new ItemInfo(0, this, "iteminfosnext");
/*  310 */           _input_.readMessage(_v_);
/*  311 */           this.iteminfosnext.put(Integer.valueOf(_k_), _v_);
/*  312 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  316 */           this.alreadygettask = _input_.readBool();
/*  317 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  321 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  323 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  332 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  336 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  338 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HanhunInfo copy()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return new HanhunInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HanhunInfo toData()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.HanhunInfo toBean()
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     return new HanhunInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HanhunInfo toDataIf()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.HanhunInfo toBeanIf()
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ItemInfo> getIteminfos()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return Logs.logMap(new LogKey(this, "iteminfos"), this.iteminfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ItemInfo> getIteminfosAsData()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*      */     
/*  395 */     HanhunInfo _o_ = this;
/*  396 */     Map<Integer, xbean.ItemInfo> iteminfos = new HashMap();
/*  397 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfos.entrySet())
/*  398 */       iteminfos.put(_e_.getKey(), new ItemInfo.Data((xbean.ItemInfo)_e_.getValue()));
/*  399 */     return iteminfos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStatus()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return this.status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSeekhelpleftcount()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     return this.seekhelpleftcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHelpotherleftcount()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     return this.helpotherleftcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getGuyshelpyou()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     return Logs.logList(new LogKey(this, "guyshelpyou"), this.guyshelpyou);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getGuyshelpyouAsData()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*      */     
/*  439 */     HanhunInfo _o_ = this;
/*  440 */     List<Long> guyshelpyou = new ArrayList();
/*  441 */     guyshelpyou.addAll(_o_.guyshelpyou);
/*  442 */     return guyshelpyou;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTimeout()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     return this.timeout;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ItemInfo> getIteminfosnext()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     return Logs.logMap(new LogKey(this, "iteminfosnext"), this.iteminfosnext);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ItemInfo> getIteminfosnextAsData()
/*      */   {
/*  465 */     _xdb_verify_unsafe_();
/*      */     
/*  467 */     HanhunInfo _o_ = this;
/*  468 */     Map<Integer, xbean.ItemInfo> iteminfosnext = new HashMap();
/*  469 */     for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfosnext.entrySet())
/*  470 */       iteminfosnext.put(_e_.getKey(), new ItemInfo.Data((xbean.ItemInfo)_e_.getValue()));
/*  471 */     return iteminfosnext;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getAlreadygettask()
/*      */   {
/*  478 */     _xdb_verify_unsafe_();
/*  479 */     return this.alreadygettask;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStatus(int _v_)
/*      */   {
/*  486 */     _xdb_verify_unsafe_();
/*  487 */     Logs.logIf(new LogKey(this, "status")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  491 */         new xdb.logs.LogInt(this, HanhunInfo.this.status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  495 */             HanhunInfo.this.status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  499 */     });
/*  500 */     this.status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSeekhelpleftcount(int _v_)
/*      */   {
/*  507 */     _xdb_verify_unsafe_();
/*  508 */     Logs.logIf(new LogKey(this, "seekhelpleftcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  512 */         new xdb.logs.LogInt(this, HanhunInfo.this.seekhelpleftcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  516 */             HanhunInfo.this.seekhelpleftcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  520 */     });
/*  521 */     this.seekhelpleftcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHelpotherleftcount(int _v_)
/*      */   {
/*  528 */     _xdb_verify_unsafe_();
/*  529 */     Logs.logIf(new LogKey(this, "helpotherleftcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  533 */         new xdb.logs.LogInt(this, HanhunInfo.this.helpotherleftcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  537 */             HanhunInfo.this.helpotherleftcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  541 */     });
/*  542 */     this.helpotherleftcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTimeout(long _v_)
/*      */   {
/*  549 */     _xdb_verify_unsafe_();
/*  550 */     Logs.logIf(new LogKey(this, "timeout")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  554 */         new xdb.logs.LogLong(this, HanhunInfo.this.timeout)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  558 */             HanhunInfo.this.timeout = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  562 */     });
/*  563 */     this.timeout = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAlreadygettask(boolean _v_)
/*      */   {
/*  570 */     _xdb_verify_unsafe_();
/*  571 */     Logs.logIf(new LogKey(this, "alreadygettask")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  575 */         new xdb.logs.LogObject(this, Boolean.valueOf(HanhunInfo.this.alreadygettask))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  579 */             HanhunInfo.this.alreadygettask = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  583 */     });
/*  584 */     this.alreadygettask = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  590 */     _xdb_verify_unsafe_();
/*  591 */     HanhunInfo _o_ = null;
/*  592 */     if ((_o1_ instanceof HanhunInfo)) { _o_ = (HanhunInfo)_o1_;
/*  593 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  594 */       return false;
/*  595 */     if (!this.iteminfos.equals(_o_.iteminfos)) return false;
/*  596 */     if (this.status != _o_.status) return false;
/*  597 */     if (this.seekhelpleftcount != _o_.seekhelpleftcount) return false;
/*  598 */     if (this.helpotherleftcount != _o_.helpotherleftcount) return false;
/*  599 */     if (!this.guyshelpyou.equals(_o_.guyshelpyou)) return false;
/*  600 */     if (this.timeout != _o_.timeout) return false;
/*  601 */     if (!this.iteminfosnext.equals(_o_.iteminfosnext)) return false;
/*  602 */     if (this.alreadygettask != _o_.alreadygettask) return false;
/*  603 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  609 */     _xdb_verify_unsafe_();
/*  610 */     int _h_ = 0;
/*  611 */     _h_ += this.iteminfos.hashCode();
/*  612 */     _h_ += this.status;
/*  613 */     _h_ += this.seekhelpleftcount;
/*  614 */     _h_ += this.helpotherleftcount;
/*  615 */     _h_ += this.guyshelpyou.hashCode();
/*  616 */     _h_ = (int)(_h_ + this.timeout);
/*  617 */     _h_ += this.iteminfosnext.hashCode();
/*  618 */     _h_ += (this.alreadygettask ? 1231 : 1237);
/*  619 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  625 */     _xdb_verify_unsafe_();
/*  626 */     StringBuilder _sb_ = new StringBuilder();
/*  627 */     _sb_.append("(");
/*  628 */     _sb_.append(this.iteminfos);
/*  629 */     _sb_.append(",");
/*  630 */     _sb_.append(this.status);
/*  631 */     _sb_.append(",");
/*  632 */     _sb_.append(this.seekhelpleftcount);
/*  633 */     _sb_.append(",");
/*  634 */     _sb_.append(this.helpotherleftcount);
/*  635 */     _sb_.append(",");
/*  636 */     _sb_.append(this.guyshelpyou);
/*  637 */     _sb_.append(",");
/*  638 */     _sb_.append(this.timeout);
/*  639 */     _sb_.append(",");
/*  640 */     _sb_.append(this.iteminfosnext);
/*  641 */     _sb_.append(",");
/*  642 */     _sb_.append(this.alreadygettask);
/*  643 */     _sb_.append(")");
/*  644 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  650 */     ListenableBean lb = new ListenableBean();
/*  651 */     lb.add(new xdb.logs.ListenableMap().setVarName("iteminfos"));
/*  652 */     lb.add(new ListenableChanged().setVarName("status"));
/*  653 */     lb.add(new ListenableChanged().setVarName("seekhelpleftcount"));
/*  654 */     lb.add(new ListenableChanged().setVarName("helpotherleftcount"));
/*  655 */     lb.add(new ListenableChanged().setVarName("guyshelpyou"));
/*  656 */     lb.add(new ListenableChanged().setVarName("timeout"));
/*  657 */     lb.add(new xdb.logs.ListenableMap().setVarName("iteminfosnext"));
/*  658 */     lb.add(new ListenableChanged().setVarName("alreadygettask"));
/*  659 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.HanhunInfo {
/*      */     private Const() {}
/*      */     
/*      */     HanhunInfo nThis() {
/*  666 */       return HanhunInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  672 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HanhunInfo copy()
/*      */     {
/*  678 */       return HanhunInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HanhunInfo toData()
/*      */     {
/*  684 */       return HanhunInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.HanhunInfo toBean()
/*      */     {
/*  689 */       return HanhunInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HanhunInfo toDataIf()
/*      */     {
/*  695 */       return HanhunInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.HanhunInfo toBeanIf()
/*      */     {
/*  700 */       return HanhunInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ItemInfo> getIteminfos()
/*      */     {
/*  707 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  708 */       return xdb.Consts.constMap(HanhunInfo.this.iteminfos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ItemInfo> getIteminfosAsData()
/*      */     {
/*  715 */       HanhunInfo.this._xdb_verify_unsafe_();
/*      */       
/*  717 */       HanhunInfo _o_ = HanhunInfo.this;
/*  718 */       Map<Integer, xbean.ItemInfo> iteminfos = new HashMap();
/*  719 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfos.entrySet())
/*  720 */         iteminfos.put(_e_.getKey(), new ItemInfo.Data((xbean.ItemInfo)_e_.getValue()));
/*  721 */       return iteminfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/*  728 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  729 */       return HanhunInfo.this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSeekhelpleftcount()
/*      */     {
/*  736 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  737 */       return HanhunInfo.this.seekhelpleftcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHelpotherleftcount()
/*      */     {
/*  744 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  745 */       return HanhunInfo.this.helpotherleftcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getGuyshelpyou()
/*      */     {
/*  752 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  753 */       return xdb.Consts.constList(HanhunInfo.this.guyshelpyou);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getGuyshelpyouAsData()
/*      */     {
/*  759 */       HanhunInfo.this._xdb_verify_unsafe_();
/*      */       
/*  761 */       HanhunInfo _o_ = HanhunInfo.this;
/*  762 */       List<Long> guyshelpyou = new ArrayList();
/*  763 */       guyshelpyou.addAll(_o_.guyshelpyou);
/*  764 */       return guyshelpyou;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimeout()
/*      */     {
/*  771 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  772 */       return HanhunInfo.this.timeout;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ItemInfo> getIteminfosnext()
/*      */     {
/*  779 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  780 */       return xdb.Consts.constMap(HanhunInfo.this.iteminfosnext);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ItemInfo> getIteminfosnextAsData()
/*      */     {
/*  787 */       HanhunInfo.this._xdb_verify_unsafe_();
/*      */       
/*  789 */       HanhunInfo _o_ = HanhunInfo.this;
/*  790 */       Map<Integer, xbean.ItemInfo> iteminfosnext = new HashMap();
/*  791 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfosnext.entrySet())
/*  792 */         iteminfosnext.put(_e_.getKey(), new ItemInfo.Data((xbean.ItemInfo)_e_.getValue()));
/*  793 */       return iteminfosnext;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getAlreadygettask()
/*      */     {
/*  800 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  801 */       return HanhunInfo.this.alreadygettask;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/*  808 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  809 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSeekhelpleftcount(int _v_)
/*      */     {
/*  816 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHelpotherleftcount(int _v_)
/*      */     {
/*  824 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimeout(long _v_)
/*      */     {
/*  832 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  833 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAlreadygettask(boolean _v_)
/*      */     {
/*  840 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  841 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  847 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  848 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  854 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  855 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  861 */       return HanhunInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  867 */       return HanhunInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  873 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  874 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  880 */       return HanhunInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  886 */       return HanhunInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  892 */       HanhunInfo.this._xdb_verify_unsafe_();
/*  893 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  899 */       return HanhunInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  905 */       return HanhunInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  911 */       return HanhunInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  917 */       return HanhunInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  923 */       return HanhunInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  929 */       return HanhunInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  935 */       return HanhunInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.HanhunInfo
/*      */   {
/*      */     private HashMap<Integer, xbean.ItemInfo> iteminfos;
/*      */     
/*      */     private int status;
/*      */     
/*      */     private int seekhelpleftcount;
/*      */     
/*      */     private int helpotherleftcount;
/*      */     
/*      */     private ArrayList<Long> guyshelpyou;
/*      */     
/*      */     private long timeout;
/*      */     
/*      */     private HashMap<Integer, xbean.ItemInfo> iteminfosnext;
/*      */     
/*      */     private boolean alreadygettask;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  961 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  966 */       this.iteminfos = new HashMap();
/*  967 */       this.guyshelpyou = new ArrayList();
/*  968 */       this.iteminfosnext = new HashMap();
/*  969 */       this.alreadygettask = false;
/*      */     }
/*      */     
/*      */     Data(xbean.HanhunInfo _o1_)
/*      */     {
/*  974 */       if ((_o1_ instanceof HanhunInfo)) { assign((HanhunInfo)_o1_);
/*  975 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  976 */       } else if ((_o1_ instanceof HanhunInfo.Const)) assign(((HanhunInfo.Const)_o1_).nThis()); else {
/*  977 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(HanhunInfo _o_) {
/*  982 */       this.iteminfos = new HashMap();
/*  983 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfos.entrySet())
/*  984 */         this.iteminfos.put(_e_.getKey(), new ItemInfo.Data((xbean.ItemInfo)_e_.getValue()));
/*  985 */       this.status = _o_.status;
/*  986 */       this.seekhelpleftcount = _o_.seekhelpleftcount;
/*  987 */       this.helpotherleftcount = _o_.helpotherleftcount;
/*  988 */       this.guyshelpyou = new ArrayList();
/*  989 */       this.guyshelpyou.addAll(_o_.guyshelpyou);
/*  990 */       this.timeout = _o_.timeout;
/*  991 */       this.iteminfosnext = new HashMap();
/*  992 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfosnext.entrySet())
/*  993 */         this.iteminfosnext.put(_e_.getKey(), new ItemInfo.Data((xbean.ItemInfo)_e_.getValue()));
/*  994 */       this.alreadygettask = _o_.alreadygettask;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  999 */       this.iteminfos = new HashMap();
/* 1000 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfos.entrySet())
/* 1001 */         this.iteminfos.put(_e_.getKey(), new ItemInfo.Data((xbean.ItemInfo)_e_.getValue()));
/* 1002 */       this.status = _o_.status;
/* 1003 */       this.seekhelpleftcount = _o_.seekhelpleftcount;
/* 1004 */       this.helpotherleftcount = _o_.helpotherleftcount;
/* 1005 */       this.guyshelpyou = new ArrayList();
/* 1006 */       this.guyshelpyou.addAll(_o_.guyshelpyou);
/* 1007 */       this.timeout = _o_.timeout;
/* 1008 */       this.iteminfosnext = new HashMap();
/* 1009 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : _o_.iteminfosnext.entrySet())
/* 1010 */         this.iteminfosnext.put(_e_.getKey(), new ItemInfo.Data((xbean.ItemInfo)_e_.getValue()));
/* 1011 */       this.alreadygettask = _o_.alreadygettask;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1017 */       _os_.compact_uint32(this.iteminfos.size());
/* 1018 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfos.entrySet())
/*      */       {
/* 1020 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1021 */         ((xbean.ItemInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1023 */       _os_.marshal(this.status);
/* 1024 */       _os_.marshal(this.seekhelpleftcount);
/* 1025 */       _os_.marshal(this.helpotherleftcount);
/* 1026 */       _os_.compact_uint32(this.guyshelpyou.size());
/* 1027 */       for (Long _v_ : this.guyshelpyou)
/*      */       {
/* 1029 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1031 */       _os_.marshal(this.timeout);
/* 1032 */       _os_.compact_uint32(this.iteminfosnext.size());
/* 1033 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfosnext.entrySet())
/*      */       {
/* 1035 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1036 */         ((xbean.ItemInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1038 */       _os_.marshal(this.alreadygettask);
/* 1039 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1046 */       int size = _os_.uncompact_uint32();
/* 1047 */       if (size >= 12)
/*      */       {
/* 1049 */         this.iteminfos = new HashMap(size * 2);
/*      */       }
/* 1051 */       for (; size > 0; size--)
/*      */       {
/* 1053 */         int _k_ = 0;
/* 1054 */         _k_ = _os_.unmarshal_int();
/* 1055 */         xbean.ItemInfo _v_ = xbean.Pod.newItemInfoData();
/* 1056 */         _v_.unmarshal(_os_);
/* 1057 */         this.iteminfos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1060 */       this.status = _os_.unmarshal_int();
/* 1061 */       this.seekhelpleftcount = _os_.unmarshal_int();
/* 1062 */       this.helpotherleftcount = _os_.unmarshal_int();
/* 1063 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1065 */         long _v_ = 0L;
/* 1066 */         _v_ = _os_.unmarshal_long();
/* 1067 */         this.guyshelpyou.add(Long.valueOf(_v_));
/*      */       }
/* 1069 */       this.timeout = _os_.unmarshal_long();
/*      */       
/* 1071 */       int size = _os_.uncompact_uint32();
/* 1072 */       if (size >= 12)
/*      */       {
/* 1074 */         this.iteminfosnext = new HashMap(size * 2);
/*      */       }
/* 1076 */       for (; size > 0; size--)
/*      */       {
/* 1078 */         int _k_ = 0;
/* 1079 */         _k_ = _os_.unmarshal_int();
/* 1080 */         xbean.ItemInfo _v_ = xbean.Pod.newItemInfoData();
/* 1081 */         _v_.unmarshal(_os_);
/* 1082 */         this.iteminfosnext.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1085 */       this.alreadygettask = _os_.unmarshal_boolean();
/* 1086 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1092 */       int _size_ = 0;
/* 1093 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfos.entrySet())
/*      */       {
/* 1095 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 1096 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/* 1098 */       _size_ += CodedOutputStream.computeInt32Size(2, this.status);
/* 1099 */       _size_ += CodedOutputStream.computeInt32Size(3, this.seekhelpleftcount);
/* 1100 */       _size_ += CodedOutputStream.computeInt32Size(4, this.helpotherleftcount);
/* 1101 */       for (Long _v_ : this.guyshelpyou)
/*      */       {
/* 1103 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/* 1105 */       _size_ += CodedOutputStream.computeInt64Size(6, this.timeout);
/* 1106 */       for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfosnext.entrySet())
/*      */       {
/* 1108 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/* 1109 */         _size_ += CodedOutputStream.computeMessageSize(7, (Message)_e_.getValue());
/*      */       }
/* 1111 */       _size_ += CodedOutputStream.computeBoolSize(8, this.alreadygettask);
/* 1112 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1120 */         for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfos.entrySet())
/*      */         {
/* 1122 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 1123 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/* 1125 */         _output_.writeInt32(2, this.status);
/* 1126 */         _output_.writeInt32(3, this.seekhelpleftcount);
/* 1127 */         _output_.writeInt32(4, this.helpotherleftcount);
/* 1128 */         for (Long _v_ : this.guyshelpyou)
/*      */         {
/* 1130 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/* 1132 */         _output_.writeInt64(6, this.timeout);
/* 1133 */         for (Map.Entry<Integer, xbean.ItemInfo> _e_ : this.iteminfosnext.entrySet())
/*      */         {
/* 1135 */           _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/* 1136 */           _output_.writeMessage(7, (Message)_e_.getValue());
/*      */         }
/* 1138 */         _output_.writeBool(8, this.alreadygettask);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1142 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1144 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1152 */         boolean done = false;
/* 1153 */         while (!done)
/*      */         {
/* 1155 */           int tag = _input_.readTag();
/* 1156 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1160 */             done = true;
/* 1161 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1165 */             int _k_ = 0;
/* 1166 */             _k_ = _input_.readInt32();
/* 1167 */             int readTag = _input_.readTag();
/* 1168 */             if (10 != readTag)
/*      */             {
/* 1170 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1172 */             xbean.ItemInfo _v_ = xbean.Pod.newItemInfoData();
/* 1173 */             _input_.readMessage(_v_);
/* 1174 */             this.iteminfos.put(Integer.valueOf(_k_), _v_);
/* 1175 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1179 */             this.status = _input_.readInt32();
/* 1180 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1184 */             this.seekhelpleftcount = _input_.readInt32();
/* 1185 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1189 */             this.helpotherleftcount = _input_.readInt32();
/* 1190 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1194 */             long _v_ = 0L;
/* 1195 */             _v_ = _input_.readInt64();
/* 1196 */             this.guyshelpyou.add(Long.valueOf(_v_));
/* 1197 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1201 */             this.timeout = _input_.readInt64();
/* 1202 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1206 */             int _k_ = 0;
/* 1207 */             _k_ = _input_.readInt32();
/* 1208 */             int readTag = _input_.readTag();
/* 1209 */             if (58 != readTag)
/*      */             {
/* 1211 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1213 */             xbean.ItemInfo _v_ = xbean.Pod.newItemInfoData();
/* 1214 */             _input_.readMessage(_v_);
/* 1215 */             this.iteminfosnext.put(Integer.valueOf(_k_), _v_);
/* 1216 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1220 */             this.alreadygettask = _input_.readBool();
/* 1221 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1225 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1227 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1236 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1240 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1242 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HanhunInfo copy()
/*      */     {
/* 1248 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HanhunInfo toData()
/*      */     {
/* 1254 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.HanhunInfo toBean()
/*      */     {
/* 1259 */       return new HanhunInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HanhunInfo toDataIf()
/*      */     {
/* 1265 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.HanhunInfo toBeanIf()
/*      */     {
/* 1270 */       return new HanhunInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1276 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1280 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1284 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1288 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1292 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1296 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1300 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ItemInfo> getIteminfos()
/*      */     {
/* 1307 */       return this.iteminfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ItemInfo> getIteminfosAsData()
/*      */     {
/* 1314 */       return this.iteminfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/* 1321 */       return this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSeekhelpleftcount()
/*      */     {
/* 1328 */       return this.seekhelpleftcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHelpotherleftcount()
/*      */     {
/* 1335 */       return this.helpotherleftcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getGuyshelpyou()
/*      */     {
/* 1342 */       return this.guyshelpyou;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getGuyshelpyouAsData()
/*      */     {
/* 1349 */       return this.guyshelpyou;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimeout()
/*      */     {
/* 1356 */       return this.timeout;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ItemInfo> getIteminfosnext()
/*      */     {
/* 1363 */       return this.iteminfosnext;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ItemInfo> getIteminfosnextAsData()
/*      */     {
/* 1370 */       return this.iteminfosnext;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getAlreadygettask()
/*      */     {
/* 1377 */       return this.alreadygettask;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/* 1384 */       this.status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSeekhelpleftcount(int _v_)
/*      */     {
/* 1391 */       this.seekhelpleftcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHelpotherleftcount(int _v_)
/*      */     {
/* 1398 */       this.helpotherleftcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimeout(long _v_)
/*      */     {
/* 1405 */       this.timeout = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAlreadygettask(boolean _v_)
/*      */     {
/* 1412 */       this.alreadygettask = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1418 */       if (!(_o1_ instanceof Data)) return false;
/* 1419 */       Data _o_ = (Data)_o1_;
/* 1420 */       if (!this.iteminfos.equals(_o_.iteminfos)) return false;
/* 1421 */       if (this.status != _o_.status) return false;
/* 1422 */       if (this.seekhelpleftcount != _o_.seekhelpleftcount) return false;
/* 1423 */       if (this.helpotherleftcount != _o_.helpotherleftcount) return false;
/* 1424 */       if (!this.guyshelpyou.equals(_o_.guyshelpyou)) return false;
/* 1425 */       if (this.timeout != _o_.timeout) return false;
/* 1426 */       if (!this.iteminfosnext.equals(_o_.iteminfosnext)) return false;
/* 1427 */       if (this.alreadygettask != _o_.alreadygettask) return false;
/* 1428 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1434 */       int _h_ = 0;
/* 1435 */       _h_ += this.iteminfos.hashCode();
/* 1436 */       _h_ += this.status;
/* 1437 */       _h_ += this.seekhelpleftcount;
/* 1438 */       _h_ += this.helpotherleftcount;
/* 1439 */       _h_ += this.guyshelpyou.hashCode();
/* 1440 */       _h_ = (int)(_h_ + this.timeout);
/* 1441 */       _h_ += this.iteminfosnext.hashCode();
/* 1442 */       _h_ += (this.alreadygettask ? 1231 : 1237);
/* 1443 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1449 */       StringBuilder _sb_ = new StringBuilder();
/* 1450 */       _sb_.append("(");
/* 1451 */       _sb_.append(this.iteminfos);
/* 1452 */       _sb_.append(",");
/* 1453 */       _sb_.append(this.status);
/* 1454 */       _sb_.append(",");
/* 1455 */       _sb_.append(this.seekhelpleftcount);
/* 1456 */       _sb_.append(",");
/* 1457 */       _sb_.append(this.helpotherleftcount);
/* 1458 */       _sb_.append(",");
/* 1459 */       _sb_.append(this.guyshelpyou);
/* 1460 */       _sb_.append(",");
/* 1461 */       _sb_.append(this.timeout);
/* 1462 */       _sb_.append(",");
/* 1463 */       _sb_.append(this.iteminfosnext);
/* 1464 */       _sb_.append(",");
/* 1465 */       _sb_.append(this.alreadygettask);
/* 1466 */       _sb_.append(")");
/* 1467 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HanhunInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */