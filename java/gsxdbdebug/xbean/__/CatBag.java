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
/*      */ import ppbio.Message;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableMap;
/*      */ 
/*      */ public final class CatBag extends XBean implements xbean.CatBag
/*      */ {
/*      */   private HashMap<Long, xbean.CatInfo> cats;
/*      */   private HashMap<Long, xbean.Item> items;
/*      */   private xbean.FeedInfo feed_info;
/*      */   private HashMap<Integer, Integer> award_info;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.cats.clear();
/*   25 */     this.items.clear();
/*   26 */     this.feed_info._reset_unsafe_();
/*   27 */     this.award_info.clear();
/*      */   }
/*      */   
/*      */   CatBag(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.cats = new HashMap();
/*   34 */     this.items = new HashMap();
/*   35 */     this.feed_info = new FeedInfo(0, this, "feed_info");
/*   36 */     this.award_info = new HashMap();
/*      */   }
/*      */   
/*      */   public CatBag()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CatBag(CatBag _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CatBag(xbean.CatBag _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof CatBag)) { assign((CatBag)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CatBag _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.cats = new HashMap();
/*   62 */     for (Map.Entry<Long, xbean.CatInfo> _e_ : _o_.cats.entrySet())
/*   63 */       this.cats.put(_e_.getKey(), new CatInfo((xbean.CatInfo)_e_.getValue(), this, "cats"));
/*   64 */     this.items = new HashMap();
/*   65 */     for (Map.Entry<Long, xbean.Item> _e_ : _o_.items.entrySet())
/*   66 */       this.items.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "items"));
/*   67 */     this.feed_info = new FeedInfo(_o_.feed_info, this, "feed_info");
/*   68 */     this.award_info = new HashMap();
/*   69 */     for (Map.Entry<Integer, Integer> _e_ : _o_.award_info.entrySet()) {
/*   70 */       this.award_info.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   75 */     this.cats = new HashMap();
/*   76 */     for (Map.Entry<Long, xbean.CatInfo> _e_ : _o_.cats.entrySet())
/*   77 */       this.cats.put(_e_.getKey(), new CatInfo((xbean.CatInfo)_e_.getValue(), this, "cats"));
/*   78 */     this.items = new HashMap();
/*   79 */     for (Map.Entry<Long, xbean.Item> _e_ : _o_.items.entrySet())
/*   80 */       this.items.put(_e_.getKey(), new Item((xbean.Item)_e_.getValue(), this, "items"));
/*   81 */     this.feed_info = new FeedInfo(_o_.feed_info, this, "feed_info");
/*   82 */     this.award_info = new HashMap();
/*   83 */     for (Map.Entry<Integer, Integer> _e_ : _o_.award_info.entrySet()) {
/*   84 */       this.award_info.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.compact_uint32(this.cats.size());
/*   92 */     for (Map.Entry<Long, xbean.CatInfo> _e_ : this.cats.entrySet())
/*      */     {
/*   94 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   95 */       ((xbean.CatInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*   97 */     _os_.compact_uint32(this.items.size());
/*   98 */     for (Map.Entry<Long, xbean.Item> _e_ : this.items.entrySet())
/*      */     {
/*  100 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  101 */       ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */     }
/*  103 */     this.feed_info.marshal(_os_);
/*  104 */     _os_.compact_uint32(this.award_info.size());
/*  105 */     for (Map.Entry<Integer, Integer> _e_ : this.award_info.entrySet())
/*      */     {
/*  107 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  108 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*      */     
/*  118 */     int size = _os_.uncompact_uint32();
/*  119 */     if (size >= 12)
/*      */     {
/*  121 */       this.cats = new HashMap(size * 2);
/*      */     }
/*  123 */     for (; size > 0; size--)
/*      */     {
/*  125 */       long _k_ = 0L;
/*  126 */       _k_ = _os_.unmarshal_long();
/*  127 */       xbean.CatInfo _v_ = new CatInfo(0, this, "cats");
/*  128 */       _v_.unmarshal(_os_);
/*  129 */       this.cats.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  133 */     int size = _os_.uncompact_uint32();
/*  134 */     if (size >= 12)
/*      */     {
/*  136 */       this.items = new HashMap(size * 2);
/*      */     }
/*  138 */     for (; size > 0; size--)
/*      */     {
/*  140 */       long _k_ = 0L;
/*  141 */       _k_ = _os_.unmarshal_long();
/*  142 */       xbean.Item _v_ = new Item(0, this, "items");
/*  143 */       _v_.unmarshal(_os_);
/*  144 */       this.items.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  147 */     this.feed_info.unmarshal(_os_);
/*      */     
/*  149 */     int size = _os_.uncompact_uint32();
/*  150 */     if (size >= 12)
/*      */     {
/*  152 */       this.award_info = new HashMap(size * 2);
/*      */     }
/*  154 */     for (; size > 0; size--)
/*      */     {
/*  156 */       int _k_ = 0;
/*  157 */       _k_ = _os_.unmarshal_int();
/*  158 */       int _v_ = 0;
/*  159 */       _v_ = _os_.unmarshal_int();
/*  160 */       this.award_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  163 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  169 */     _xdb_verify_unsafe_();
/*  170 */     int _size_ = 0;
/*  171 */     for (Map.Entry<Long, xbean.CatInfo> _e_ : this.cats.entrySet())
/*      */     {
/*  173 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  174 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  176 */     for (Map.Entry<Long, xbean.Item> _e_ : this.items.entrySet())
/*      */     {
/*  178 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  179 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */     }
/*  181 */     _size_ += CodedOutputStream.computeMessageSize(3, this.feed_info);
/*  182 */     for (Map.Entry<Integer, Integer> _e_ : this.award_info.entrySet())
/*      */     {
/*  184 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  185 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  187 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  193 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  196 */       for (Map.Entry<Long, xbean.CatInfo> _e_ : this.cats.entrySet())
/*      */       {
/*  198 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  199 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  201 */       for (Map.Entry<Long, xbean.Item> _e_ : this.items.entrySet())
/*      */       {
/*  203 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  204 */         _output_.writeMessage(2, (Message)_e_.getValue());
/*      */       }
/*  206 */       _output_.writeMessage(3, this.feed_info);
/*  207 */       for (Map.Entry<Integer, Integer> _e_ : this.award_info.entrySet())
/*      */       {
/*  209 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  210 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  215 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  217 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  223 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  226 */       boolean done = false;
/*  227 */       while (!done)
/*      */       {
/*  229 */         int tag = _input_.readTag();
/*  230 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  234 */           done = true;
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  239 */           long _k_ = 0L;
/*  240 */           _k_ = _input_.readInt64();
/*  241 */           int readTag = _input_.readTag();
/*  242 */           if (10 != readTag)
/*      */           {
/*  244 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  246 */           xbean.CatInfo _v_ = new CatInfo(0, this, "cats");
/*  247 */           _input_.readMessage(_v_);
/*  248 */           this.cats.put(Long.valueOf(_k_), _v_);
/*  249 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  253 */           long _k_ = 0L;
/*  254 */           _k_ = _input_.readInt64();
/*  255 */           int readTag = _input_.readTag();
/*  256 */           if (18 != readTag)
/*      */           {
/*  258 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  260 */           xbean.Item _v_ = new Item(0, this, "items");
/*  261 */           _input_.readMessage(_v_);
/*  262 */           this.items.put(Long.valueOf(_k_), _v_);
/*  263 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  267 */           _input_.readMessage(this.feed_info);
/*  268 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  272 */           int _k_ = 0;
/*  273 */           _k_ = _input_.readInt32();
/*  274 */           int readTag = _input_.readTag();
/*  275 */           if (32 != readTag)
/*      */           {
/*  277 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  279 */           int _v_ = 0;
/*  280 */           _v_ = _input_.readInt32();
/*  281 */           this.award_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  282 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  286 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  288 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  297 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  301 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  303 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CatBag copy()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return new CatBag(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CatBag toData()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CatBag toBean()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return new CatBag(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CatBag toDataIf()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CatBag toBeanIf()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CatInfo> getCats()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return xdb.Logs.logMap(new xdb.LogKey(this, "cats"), this.cats);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CatInfo> getCatsAsData()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*      */     
/*  360 */     CatBag _o_ = this;
/*  361 */     Map<Long, xbean.CatInfo> cats = new HashMap();
/*  362 */     for (Map.Entry<Long, xbean.CatInfo> _e_ : _o_.cats.entrySet())
/*  363 */       cats.put(_e_.getKey(), new CatInfo.Data((xbean.CatInfo)_e_.getValue()));
/*  364 */     return cats;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.Item> getItems()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return xdb.Logs.logMap(new xdb.LogKey(this, "items"), this.items);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.Item> getItemsAsData()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*      */     
/*  381 */     CatBag _o_ = this;
/*  382 */     Map<Long, xbean.Item> items = new HashMap();
/*  383 */     for (Map.Entry<Long, xbean.Item> _e_ : _o_.items.entrySet())
/*  384 */       items.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  385 */     return items;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.FeedInfo getFeed_info()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     return this.feed_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAward_info()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     return xdb.Logs.logMap(new xdb.LogKey(this, "award_info"), this.award_info);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAward_infoAsData()
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*      */     
/*  410 */     CatBag _o_ = this;
/*  411 */     Map<Integer, Integer> award_info = new HashMap();
/*  412 */     for (Map.Entry<Integer, Integer> _e_ : _o_.award_info.entrySet())
/*  413 */       award_info.put(_e_.getKey(), _e_.getValue());
/*  414 */     return award_info;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     CatBag _o_ = null;
/*  422 */     if ((_o1_ instanceof CatBag)) { _o_ = (CatBag)_o1_;
/*  423 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  424 */       return false;
/*  425 */     if (!this.cats.equals(_o_.cats)) return false;
/*  426 */     if (!this.items.equals(_o_.items)) return false;
/*  427 */     if (!this.feed_info.equals(_o_.feed_info)) return false;
/*  428 */     if (!this.award_info.equals(_o_.award_info)) return false;
/*  429 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     int _h_ = 0;
/*  437 */     _h_ += this.cats.hashCode();
/*  438 */     _h_ += this.items.hashCode();
/*  439 */     _h_ += this.feed_info.hashCode();
/*  440 */     _h_ += this.award_info.hashCode();
/*  441 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     StringBuilder _sb_ = new StringBuilder();
/*  449 */     _sb_.append("(");
/*  450 */     _sb_.append(this.cats);
/*  451 */     _sb_.append(",");
/*  452 */     _sb_.append(this.items);
/*  453 */     _sb_.append(",");
/*  454 */     _sb_.append(this.feed_info);
/*  455 */     _sb_.append(",");
/*  456 */     _sb_.append(this.award_info);
/*  457 */     _sb_.append(")");
/*  458 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  464 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  465 */     lb.add(new ListenableMap().setVarName("cats"));
/*  466 */     lb.add(new ListenableMap().setVarName("items"));
/*  467 */     lb.add(new xdb.logs.ListenableChanged().setVarName("feed_info"));
/*  468 */     lb.add(new ListenableMap().setVarName("award_info"));
/*  469 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CatBag {
/*      */     private Const() {}
/*      */     
/*      */     CatBag nThis() {
/*  476 */       return CatBag.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  482 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatBag copy()
/*      */     {
/*  488 */       return CatBag.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatBag toData()
/*      */     {
/*  494 */       return CatBag.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CatBag toBean()
/*      */     {
/*  499 */       return CatBag.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatBag toDataIf()
/*      */     {
/*  505 */       return CatBag.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CatBag toBeanIf()
/*      */     {
/*  510 */       return CatBag.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CatInfo> getCats()
/*      */     {
/*  517 */       CatBag.this._xdb_verify_unsafe_();
/*  518 */       return xdb.Consts.constMap(CatBag.this.cats);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CatInfo> getCatsAsData()
/*      */     {
/*  525 */       CatBag.this._xdb_verify_unsafe_();
/*      */       
/*  527 */       CatBag _o_ = CatBag.this;
/*  528 */       Map<Long, xbean.CatInfo> cats = new HashMap();
/*  529 */       for (Map.Entry<Long, xbean.CatInfo> _e_ : _o_.cats.entrySet())
/*  530 */         cats.put(_e_.getKey(), new CatInfo.Data((xbean.CatInfo)_e_.getValue()));
/*  531 */       return cats;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Item> getItems()
/*      */     {
/*  538 */       CatBag.this._xdb_verify_unsafe_();
/*  539 */       return xdb.Consts.constMap(CatBag.this.items);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Item> getItemsAsData()
/*      */     {
/*  546 */       CatBag.this._xdb_verify_unsafe_();
/*      */       
/*  548 */       CatBag _o_ = CatBag.this;
/*  549 */       Map<Long, xbean.Item> items = new HashMap();
/*  550 */       for (Map.Entry<Long, xbean.Item> _e_ : _o_.items.entrySet())
/*  551 */         items.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  552 */       return items;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FeedInfo getFeed_info()
/*      */     {
/*  559 */       CatBag.this._xdb_verify_unsafe_();
/*  560 */       return (xbean.FeedInfo)xdb.Consts.toConst(CatBag.this.feed_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAward_info()
/*      */     {
/*  567 */       CatBag.this._xdb_verify_unsafe_();
/*  568 */       return xdb.Consts.constMap(CatBag.this.award_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAward_infoAsData()
/*      */     {
/*  575 */       CatBag.this._xdb_verify_unsafe_();
/*      */       
/*  577 */       CatBag _o_ = CatBag.this;
/*  578 */       Map<Integer, Integer> award_info = new HashMap();
/*  579 */       for (Map.Entry<Integer, Integer> _e_ : _o_.award_info.entrySet())
/*  580 */         award_info.put(_e_.getKey(), _e_.getValue());
/*  581 */       return award_info;
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  587 */       CatBag.this._xdb_verify_unsafe_();
/*  588 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  594 */       CatBag.this._xdb_verify_unsafe_();
/*  595 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  601 */       return CatBag.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  607 */       return CatBag.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  613 */       CatBag.this._xdb_verify_unsafe_();
/*  614 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  620 */       return CatBag.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  626 */       return CatBag.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  632 */       CatBag.this._xdb_verify_unsafe_();
/*  633 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  639 */       return CatBag.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  645 */       return CatBag.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  651 */       return CatBag.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  657 */       return CatBag.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  663 */       return CatBag.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  669 */       return CatBag.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  675 */       return CatBag.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CatBag
/*      */   {
/*      */     private HashMap<Long, xbean.CatInfo> cats;
/*      */     
/*      */     private HashMap<Long, xbean.Item> items;
/*      */     
/*      */     private xbean.FeedInfo feed_info;
/*      */     
/*      */     private HashMap<Integer, Integer> award_info;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  693 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  698 */       this.cats = new HashMap();
/*  699 */       this.items = new HashMap();
/*  700 */       this.feed_info = new FeedInfo.Data();
/*  701 */       this.award_info = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.CatBag _o1_)
/*      */     {
/*  706 */       if ((_o1_ instanceof CatBag)) { assign((CatBag)_o1_);
/*  707 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  708 */       } else if ((_o1_ instanceof CatBag.Const)) assign(((CatBag.Const)_o1_).nThis()); else {
/*  709 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CatBag _o_) {
/*  714 */       this.cats = new HashMap();
/*  715 */       for (Map.Entry<Long, xbean.CatInfo> _e_ : _o_.cats.entrySet())
/*  716 */         this.cats.put(_e_.getKey(), new CatInfo.Data((xbean.CatInfo)_e_.getValue()));
/*  717 */       this.items = new HashMap();
/*  718 */       for (Map.Entry<Long, xbean.Item> _e_ : _o_.items.entrySet())
/*  719 */         this.items.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  720 */       this.feed_info = new FeedInfo.Data(_o_.feed_info);
/*  721 */       this.award_info = new HashMap();
/*  722 */       for (Map.Entry<Integer, Integer> _e_ : _o_.award_info.entrySet()) {
/*  723 */         this.award_info.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  728 */       this.cats = new HashMap();
/*  729 */       for (Map.Entry<Long, xbean.CatInfo> _e_ : _o_.cats.entrySet())
/*  730 */         this.cats.put(_e_.getKey(), new CatInfo.Data((xbean.CatInfo)_e_.getValue()));
/*  731 */       this.items = new HashMap();
/*  732 */       for (Map.Entry<Long, xbean.Item> _e_ : _o_.items.entrySet())
/*  733 */         this.items.put(_e_.getKey(), new Item.Data((xbean.Item)_e_.getValue()));
/*  734 */       this.feed_info = new FeedInfo.Data(_o_.feed_info);
/*  735 */       this.award_info = new HashMap();
/*  736 */       for (Map.Entry<Integer, Integer> _e_ : _o_.award_info.entrySet()) {
/*  737 */         this.award_info.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  743 */       _os_.compact_uint32(this.cats.size());
/*  744 */       for (Map.Entry<Long, xbean.CatInfo> _e_ : this.cats.entrySet())
/*      */       {
/*  746 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  747 */         ((xbean.CatInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  749 */       _os_.compact_uint32(this.items.size());
/*  750 */       for (Map.Entry<Long, xbean.Item> _e_ : this.items.entrySet())
/*      */       {
/*  752 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  753 */         ((xbean.Item)_e_.getValue()).marshal(_os_);
/*      */       }
/*  755 */       this.feed_info.marshal(_os_);
/*  756 */       _os_.compact_uint32(this.award_info.size());
/*  757 */       for (Map.Entry<Integer, Integer> _e_ : this.award_info.entrySet())
/*      */       {
/*  759 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  760 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
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
/*  772 */         this.cats = new HashMap(size * 2);
/*      */       }
/*  774 */       for (; size > 0; size--)
/*      */       {
/*  776 */         long _k_ = 0L;
/*  777 */         _k_ = _os_.unmarshal_long();
/*  778 */         xbean.CatInfo _v_ = xbean.Pod.newCatInfoData();
/*  779 */         _v_.unmarshal(_os_);
/*  780 */         this.cats.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  784 */       int size = _os_.uncompact_uint32();
/*  785 */       if (size >= 12)
/*      */       {
/*  787 */         this.items = new HashMap(size * 2);
/*      */       }
/*  789 */       for (; size > 0; size--)
/*      */       {
/*  791 */         long _k_ = 0L;
/*  792 */         _k_ = _os_.unmarshal_long();
/*  793 */         xbean.Item _v_ = xbean.Pod.newItemData();
/*  794 */         _v_.unmarshal(_os_);
/*  795 */         this.items.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  798 */       this.feed_info.unmarshal(_os_);
/*      */       
/*  800 */       int size = _os_.uncompact_uint32();
/*  801 */       if (size >= 12)
/*      */       {
/*  803 */         this.award_info = new HashMap(size * 2);
/*      */       }
/*  805 */       for (; size > 0; size--)
/*      */       {
/*  807 */         int _k_ = 0;
/*  808 */         _k_ = _os_.unmarshal_int();
/*  809 */         int _v_ = 0;
/*  810 */         _v_ = _os_.unmarshal_int();
/*  811 */         this.award_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  814 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  820 */       int _size_ = 0;
/*  821 */       for (Map.Entry<Long, xbean.CatInfo> _e_ : this.cats.entrySet())
/*      */       {
/*  823 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  824 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/*  826 */       for (Map.Entry<Long, xbean.Item> _e_ : this.items.entrySet())
/*      */       {
/*  828 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  829 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */       }
/*  831 */       _size_ += CodedOutputStream.computeMessageSize(3, this.feed_info);
/*  832 */       for (Map.Entry<Integer, Integer> _e_ : this.award_info.entrySet())
/*      */       {
/*  834 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  835 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  837 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  845 */         for (Map.Entry<Long, xbean.CatInfo> _e_ : this.cats.entrySet())
/*      */         {
/*  847 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  848 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/*  850 */         for (Map.Entry<Long, xbean.Item> _e_ : this.items.entrySet())
/*      */         {
/*  852 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  853 */           _output_.writeMessage(2, (Message)_e_.getValue());
/*      */         }
/*  855 */         _output_.writeMessage(3, this.feed_info);
/*  856 */         for (Map.Entry<Integer, Integer> _e_ : this.award_info.entrySet())
/*      */         {
/*  858 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  859 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  864 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  866 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  874 */         boolean done = false;
/*  875 */         while (!done)
/*      */         {
/*  877 */           int tag = _input_.readTag();
/*  878 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  882 */             done = true;
/*  883 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  887 */             long _k_ = 0L;
/*  888 */             _k_ = _input_.readInt64();
/*  889 */             int readTag = _input_.readTag();
/*  890 */             if (10 != readTag)
/*      */             {
/*  892 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  894 */             xbean.CatInfo _v_ = xbean.Pod.newCatInfoData();
/*  895 */             _input_.readMessage(_v_);
/*  896 */             this.cats.put(Long.valueOf(_k_), _v_);
/*  897 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  901 */             long _k_ = 0L;
/*  902 */             _k_ = _input_.readInt64();
/*  903 */             int readTag = _input_.readTag();
/*  904 */             if (18 != readTag)
/*      */             {
/*  906 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  908 */             xbean.Item _v_ = xbean.Pod.newItemData();
/*  909 */             _input_.readMessage(_v_);
/*  910 */             this.items.put(Long.valueOf(_k_), _v_);
/*  911 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  915 */             _input_.readMessage(this.feed_info);
/*  916 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  920 */             int _k_ = 0;
/*  921 */             _k_ = _input_.readInt32();
/*  922 */             int readTag = _input_.readTag();
/*  923 */             if (32 != readTag)
/*      */             {
/*  925 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  927 */             int _v_ = 0;
/*  928 */             _v_ = _input_.readInt32();
/*  929 */             this.award_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  930 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  934 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  936 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  945 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  949 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  951 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatBag copy()
/*      */     {
/*  957 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatBag toData()
/*      */     {
/*  963 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CatBag toBean()
/*      */     {
/*  968 */       return new CatBag(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CatBag toDataIf()
/*      */     {
/*  974 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CatBag toBeanIf()
/*      */     {
/*  979 */       return new CatBag(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  985 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  989 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  993 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  997 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1001 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1005 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1009 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CatInfo> getCats()
/*      */     {
/* 1016 */       return this.cats;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CatInfo> getCatsAsData()
/*      */     {
/* 1023 */       return this.cats;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Item> getItems()
/*      */     {
/* 1030 */       return this.items;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.Item> getItemsAsData()
/*      */     {
/* 1037 */       return this.items;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.FeedInfo getFeed_info()
/*      */     {
/* 1044 */       return this.feed_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAward_info()
/*      */     {
/* 1051 */       return this.award_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAward_infoAsData()
/*      */     {
/* 1058 */       return this.award_info;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1064 */       if (!(_o1_ instanceof Data)) return false;
/* 1065 */       Data _o_ = (Data)_o1_;
/* 1066 */       if (!this.cats.equals(_o_.cats)) return false;
/* 1067 */       if (!this.items.equals(_o_.items)) return false;
/* 1068 */       if (!this.feed_info.equals(_o_.feed_info)) return false;
/* 1069 */       if (!this.award_info.equals(_o_.award_info)) return false;
/* 1070 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1076 */       int _h_ = 0;
/* 1077 */       _h_ += this.cats.hashCode();
/* 1078 */       _h_ += this.items.hashCode();
/* 1079 */       _h_ += this.feed_info.hashCode();
/* 1080 */       _h_ += this.award_info.hashCode();
/* 1081 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1087 */       StringBuilder _sb_ = new StringBuilder();
/* 1088 */       _sb_.append("(");
/* 1089 */       _sb_.append(this.cats);
/* 1090 */       _sb_.append(",");
/* 1091 */       _sb_.append(this.items);
/* 1092 */       _sb_.append(",");
/* 1093 */       _sb_.append(this.feed_info);
/* 1094 */       _sb_.append(",");
/* 1095 */       _sb_.append(this.award_info);
/* 1096 */       _sb_.append(")");
/* 1097 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CatBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */