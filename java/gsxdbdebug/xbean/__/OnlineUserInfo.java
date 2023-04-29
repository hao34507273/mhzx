/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class OnlineUserInfo extends XBean implements xbean.OnlineUserInfo
/*      */ {
/*      */   private int peer;
/*      */   private int func;
/*      */   private int funcparm;
/*      */   private int algorithm;
/*      */   private String channel;
/*      */   private String registerchannel;
/*      */   private String gameappid;
/*      */   private int platid;
/*      */   private int telecomoper;
/*      */   private HashMap<String, String> jsonparams;
/*      */   private boolean fake_plat;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   38 */     this.peer = 0;
/*   39 */     this.func = 0;
/*   40 */     this.funcparm = 0;
/*   41 */     this.algorithm = 0;
/*   42 */     this.channel = "";
/*   43 */     this.registerchannel = "";
/*   44 */     this.gameappid = "";
/*   45 */     this.platid = 0;
/*   46 */     this.telecomoper = 0;
/*   47 */     this.jsonparams.clear();
/*   48 */     this.fake_plat = false;
/*      */   }
/*      */   
/*      */   OnlineUserInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     this.channel = "";
/*   55 */     this.registerchannel = "";
/*   56 */     this.gameappid = "";
/*   57 */     this.jsonparams = new HashMap();
/*   58 */     this.fake_plat = false;
/*      */   }
/*      */   
/*      */   public OnlineUserInfo()
/*      */   {
/*   63 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public OnlineUserInfo(OnlineUserInfo _o_)
/*      */   {
/*   68 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   OnlineUserInfo(xbean.OnlineUserInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   73 */     super(_xp_, _vn_);
/*   74 */     if ((_o1_ instanceof OnlineUserInfo)) { assign((OnlineUserInfo)_o1_);
/*   75 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   76 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   77 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(OnlineUserInfo _o_) {
/*   82 */     _o_._xdb_verify_unsafe_();
/*   83 */     this.peer = _o_.peer;
/*   84 */     this.func = _o_.func;
/*   85 */     this.funcparm = _o_.funcparm;
/*   86 */     this.algorithm = _o_.algorithm;
/*   87 */     this.channel = _o_.channel;
/*   88 */     this.registerchannel = _o_.registerchannel;
/*   89 */     this.gameappid = _o_.gameappid;
/*   90 */     this.platid = _o_.platid;
/*   91 */     this.telecomoper = _o_.telecomoper;
/*   92 */     this.jsonparams = new HashMap();
/*   93 */     for (Map.Entry<String, String> _e_ : _o_.jsonparams.entrySet())
/*   94 */       this.jsonparams.put(_e_.getKey(), _e_.getValue());
/*   95 */     this.fake_plat = _o_.fake_plat;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  100 */     this.peer = _o_.peer;
/*  101 */     this.func = _o_.func;
/*  102 */     this.funcparm = _o_.funcparm;
/*  103 */     this.algorithm = _o_.algorithm;
/*  104 */     this.channel = _o_.channel;
/*  105 */     this.registerchannel = _o_.registerchannel;
/*  106 */     this.gameappid = _o_.gameappid;
/*  107 */     this.platid = _o_.platid;
/*  108 */     this.telecomoper = _o_.telecomoper;
/*  109 */     this.jsonparams = new HashMap();
/*  110 */     for (Map.Entry<String, String> _e_ : _o_.jsonparams.entrySet())
/*  111 */       this.jsonparams.put(_e_.getKey(), _e_.getValue());
/*  112 */     this.fake_plat = _o_.fake_plat;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     _os_.marshal(this.peer);
/*  120 */     _os_.marshal(this.func);
/*  121 */     _os_.marshal(this.funcparm);
/*  122 */     _os_.marshal(this.algorithm);
/*  123 */     _os_.marshal(this.channel, "UTF-16LE");
/*  124 */     _os_.marshal(this.registerchannel, "UTF-16LE");
/*  125 */     _os_.marshal(this.gameappid, "UTF-16LE");
/*  126 */     _os_.marshal(this.platid);
/*  127 */     _os_.marshal(this.telecomoper);
/*  128 */     _os_.compact_uint32(this.jsonparams.size());
/*  129 */     for (Map.Entry<String, String> _e_ : this.jsonparams.entrySet())
/*      */     {
/*  131 */       _os_.marshal((String)_e_.getKey(), "UTF-16LE");
/*  132 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */     }
/*  134 */     _os_.marshal(this.fake_plat);
/*  135 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*  142 */     this.peer = _os_.unmarshal_int();
/*  143 */     this.func = _os_.unmarshal_int();
/*  144 */     this.funcparm = _os_.unmarshal_int();
/*  145 */     this.algorithm = _os_.unmarshal_int();
/*  146 */     this.channel = _os_.unmarshal_String("UTF-16LE");
/*  147 */     this.registerchannel = _os_.unmarshal_String("UTF-16LE");
/*  148 */     this.gameappid = _os_.unmarshal_String("UTF-16LE");
/*  149 */     this.platid = _os_.unmarshal_int();
/*  150 */     this.telecomoper = _os_.unmarshal_int();
/*      */     
/*  152 */     int size = _os_.uncompact_uint32();
/*  153 */     if (size >= 12)
/*      */     {
/*  155 */       this.jsonparams = new HashMap(size * 2);
/*      */     }
/*  157 */     for (; size > 0; size--)
/*      */     {
/*  159 */       String _k_ = "";
/*  160 */       _k_ = _os_.unmarshal_String("UTF-16LE");
/*  161 */       String _v_ = "";
/*  162 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  163 */       this.jsonparams.put(_k_, _v_);
/*      */     }
/*      */     
/*  166 */     this.fake_plat = _os_.unmarshal_boolean();
/*  167 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  173 */     _xdb_verify_unsafe_();
/*  174 */     int _size_ = 0;
/*  175 */     _size_ += CodedOutputStream.computeInt32Size(1, this.peer);
/*  176 */     _size_ += CodedOutputStream.computeInt32Size(2, this.func);
/*  177 */     _size_ += CodedOutputStream.computeInt32Size(3, this.funcparm);
/*  178 */     _size_ += CodedOutputStream.computeInt32Size(4, this.algorithm);
/*      */     try
/*      */     {
/*  181 */       _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(this.channel, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  185 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  189 */       _size_ += CodedOutputStream.computeBytesSize(6, ByteString.copyFrom(this.registerchannel, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  193 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  197 */       _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.gameappid, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  201 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  203 */     _size_ += CodedOutputStream.computeInt32Size(8, this.platid);
/*  204 */     _size_ += CodedOutputStream.computeInt32Size(9, this.telecomoper);
/*  205 */     for (Map.Entry<String, String> _e_ : this.jsonparams.entrySet())
/*      */     {
/*      */       try
/*      */       {
/*  209 */         _size_ += CodedOutputStream.computeBytesSize(10, ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  213 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/*  217 */         _size_ += CodedOutputStream.computeBytesSize(10, ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  221 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  224 */     _size_ += CodedOutputStream.computeBoolSize(11, this.fake_plat);
/*  225 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  231 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  234 */       _output_.writeInt32(1, this.peer);
/*  235 */       _output_.writeInt32(2, this.func);
/*  236 */       _output_.writeInt32(3, this.funcparm);
/*  237 */       _output_.writeInt32(4, this.algorithm);
/*  238 */       _output_.writeBytes(5, ByteString.copyFrom(this.channel, "UTF-16LE"));
/*  239 */       _output_.writeBytes(6, ByteString.copyFrom(this.registerchannel, "UTF-16LE"));
/*  240 */       _output_.writeBytes(7, ByteString.copyFrom(this.gameappid, "UTF-16LE"));
/*  241 */       _output_.writeInt32(8, this.platid);
/*  242 */       _output_.writeInt32(9, this.telecomoper);
/*  243 */       for (Map.Entry<String, String> _e_ : this.jsonparams.entrySet())
/*      */       {
/*  245 */         _output_.writeBytes(10, ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/*  246 */         _output_.writeBytes(10, ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*  248 */       _output_.writeBool(11, this.fake_plat);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  252 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  254 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  263 */       boolean done = false;
/*  264 */       while (!done)
/*      */       {
/*  266 */         int tag = _input_.readTag();
/*  267 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  271 */           done = true;
/*  272 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  276 */           this.peer = _input_.readInt32();
/*  277 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  281 */           this.func = _input_.readInt32();
/*  282 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  286 */           this.funcparm = _input_.readInt32();
/*  287 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  291 */           this.algorithm = _input_.readInt32();
/*  292 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  296 */           this.channel = _input_.readBytes().toString("UTF-16LE");
/*  297 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  301 */           this.registerchannel = _input_.readBytes().toString("UTF-16LE");
/*  302 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  306 */           this.gameappid = _input_.readBytes().toString("UTF-16LE");
/*  307 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  311 */           this.platid = _input_.readInt32();
/*  312 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  316 */           this.telecomoper = _input_.readInt32();
/*  317 */           break;
/*      */         
/*      */ 
/*      */         case 82: 
/*  321 */           String _k_ = "";
/*  322 */           _k_ = _input_.readBytes().toString("UTF-16LE");
/*  323 */           int readTag = _input_.readTag();
/*  324 */           if (82 != readTag)
/*      */           {
/*  326 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  328 */           String _v_ = "";
/*  329 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  330 */           this.jsonparams.put(_k_, _v_);
/*  331 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  335 */           this.fake_plat = _input_.readBool();
/*  336 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  340 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  342 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  351 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  355 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  357 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OnlineUserInfo copy()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return new OnlineUserInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OnlineUserInfo toData()
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.OnlineUserInfo toBean()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return new OnlineUserInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OnlineUserInfo toDataIf()
/*      */   {
/*  383 */     _xdb_verify_unsafe_();
/*  384 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.OnlineUserInfo toBeanIf()
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPeer()
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     return this.peer;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFunc()
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     return this.func;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFuncparm()
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     return this.funcparm;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAlgorithm()
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*  429 */     return this.algorithm;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getChannel()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     return this.channel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getChannelOctets()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     return Octets.wrap(getChannel(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getRegisterchannel()
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     return this.registerchannel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getRegisterchannelOctets()
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*  461 */     return Octets.wrap(getRegisterchannel(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getGameappid()
/*      */   {
/*  468 */     _xdb_verify_unsafe_();
/*  469 */     return this.gameappid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getGameappidOctets()
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*  477 */     return Octets.wrap(getGameappid(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPlatid()
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     return this.platid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTelecomoper()
/*      */   {
/*  492 */     _xdb_verify_unsafe_();
/*  493 */     return this.telecomoper;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<String, String> getJsonparams()
/*      */   {
/*  500 */     _xdb_verify_unsafe_();
/*  501 */     return Logs.logMap(new LogKey(this, "jsonparams"), this.jsonparams);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<String, String> getJsonparamsAsData()
/*      */   {
/*  508 */     _xdb_verify_unsafe_();
/*      */     
/*  510 */     OnlineUserInfo _o_ = this;
/*  511 */     Map<String, String> jsonparams = new HashMap();
/*  512 */     for (Map.Entry<String, String> _e_ : _o_.jsonparams.entrySet())
/*  513 */       jsonparams.put(_e_.getKey(), _e_.getValue());
/*  514 */     return jsonparams;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getFake_plat()
/*      */   {
/*  521 */     _xdb_verify_unsafe_();
/*  522 */     return this.fake_plat;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPeer(int _v_)
/*      */   {
/*  529 */     _xdb_verify_unsafe_();
/*  530 */     Logs.logIf(new LogKey(this, "peer")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  534 */         new LogInt(this, OnlineUserInfo.this.peer)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  538 */             OnlineUserInfo.this.peer = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  542 */     });
/*  543 */     this.peer = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFunc(int _v_)
/*      */   {
/*  550 */     _xdb_verify_unsafe_();
/*  551 */     Logs.logIf(new LogKey(this, "func")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  555 */         new LogInt(this, OnlineUserInfo.this.func)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  559 */             OnlineUserInfo.this.func = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  563 */     });
/*  564 */     this.func = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFuncparm(int _v_)
/*      */   {
/*  571 */     _xdb_verify_unsafe_();
/*  572 */     Logs.logIf(new LogKey(this, "funcparm")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  576 */         new LogInt(this, OnlineUserInfo.this.funcparm)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  580 */             OnlineUserInfo.this.funcparm = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  584 */     });
/*  585 */     this.funcparm = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAlgorithm(int _v_)
/*      */   {
/*  592 */     _xdb_verify_unsafe_();
/*  593 */     Logs.logIf(new LogKey(this, "algorithm")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  597 */         new LogInt(this, OnlineUserInfo.this.algorithm)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  601 */             OnlineUserInfo.this.algorithm = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  605 */     });
/*  606 */     this.algorithm = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChannel(String _v_)
/*      */   {
/*  613 */     _xdb_verify_unsafe_();
/*  614 */     if (null == _v_)
/*  615 */       throw new NullPointerException();
/*  616 */     Logs.logIf(new LogKey(this, "channel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  620 */         new xdb.logs.LogString(this, OnlineUserInfo.this.channel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  624 */             OnlineUserInfo.this.channel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  628 */     });
/*  629 */     this.channel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChannelOctets(Octets _v_)
/*      */   {
/*  636 */     _xdb_verify_unsafe_();
/*  637 */     setChannel(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRegisterchannel(String _v_)
/*      */   {
/*  644 */     _xdb_verify_unsafe_();
/*  645 */     if (null == _v_)
/*  646 */       throw new NullPointerException();
/*  647 */     Logs.logIf(new LogKey(this, "registerchannel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  651 */         new xdb.logs.LogString(this, OnlineUserInfo.this.registerchannel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  655 */             OnlineUserInfo.this.registerchannel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  659 */     });
/*  660 */     this.registerchannel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRegisterchannelOctets(Octets _v_)
/*      */   {
/*  667 */     _xdb_verify_unsafe_();
/*  668 */     setRegisterchannel(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGameappid(String _v_)
/*      */   {
/*  675 */     _xdb_verify_unsafe_();
/*  676 */     if (null == _v_)
/*  677 */       throw new NullPointerException();
/*  678 */     Logs.logIf(new LogKey(this, "gameappid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  682 */         new xdb.logs.LogString(this, OnlineUserInfo.this.gameappid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  686 */             OnlineUserInfo.this.gameappid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  690 */     });
/*  691 */     this.gameappid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGameappidOctets(Octets _v_)
/*      */   {
/*  698 */     _xdb_verify_unsafe_();
/*  699 */     setGameappid(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPlatid(int _v_)
/*      */   {
/*  706 */     _xdb_verify_unsafe_();
/*  707 */     Logs.logIf(new LogKey(this, "platid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  711 */         new LogInt(this, OnlineUserInfo.this.platid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  715 */             OnlineUserInfo.this.platid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  719 */     });
/*  720 */     this.platid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTelecomoper(int _v_)
/*      */   {
/*  727 */     _xdb_verify_unsafe_();
/*  728 */     Logs.logIf(new LogKey(this, "telecomoper")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  732 */         new LogInt(this, OnlineUserInfo.this.telecomoper)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  736 */             OnlineUserInfo.this.telecomoper = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  740 */     });
/*  741 */     this.telecomoper = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFake_plat(boolean _v_)
/*      */   {
/*  748 */     _xdb_verify_unsafe_();
/*  749 */     Logs.logIf(new LogKey(this, "fake_plat")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  753 */         new xdb.logs.LogObject(this, Boolean.valueOf(OnlineUserInfo.this.fake_plat))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  757 */             OnlineUserInfo.this.fake_plat = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  761 */     });
/*  762 */     this.fake_plat = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  768 */     _xdb_verify_unsafe_();
/*  769 */     OnlineUserInfo _o_ = null;
/*  770 */     if ((_o1_ instanceof OnlineUserInfo)) { _o_ = (OnlineUserInfo)_o1_;
/*  771 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  772 */       return false;
/*  773 */     if (this.peer != _o_.peer) return false;
/*  774 */     if (this.func != _o_.func) return false;
/*  775 */     if (this.funcparm != _o_.funcparm) return false;
/*  776 */     if (this.algorithm != _o_.algorithm) return false;
/*  777 */     if (!this.channel.equals(_o_.channel)) return false;
/*  778 */     if (!this.registerchannel.equals(_o_.registerchannel)) return false;
/*  779 */     if (!this.gameappid.equals(_o_.gameappid)) return false;
/*  780 */     if (this.platid != _o_.platid) return false;
/*  781 */     if (this.telecomoper != _o_.telecomoper) return false;
/*  782 */     if (!this.jsonparams.equals(_o_.jsonparams)) return false;
/*  783 */     if (this.fake_plat != _o_.fake_plat) return false;
/*  784 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  790 */     _xdb_verify_unsafe_();
/*  791 */     int _h_ = 0;
/*  792 */     _h_ += this.peer;
/*  793 */     _h_ += this.func;
/*  794 */     _h_ += this.funcparm;
/*  795 */     _h_ += this.algorithm;
/*  796 */     _h_ += this.channel.hashCode();
/*  797 */     _h_ += this.registerchannel.hashCode();
/*  798 */     _h_ += this.gameappid.hashCode();
/*  799 */     _h_ += this.platid;
/*  800 */     _h_ += this.telecomoper;
/*  801 */     _h_ += this.jsonparams.hashCode();
/*  802 */     _h_ += (this.fake_plat ? 1231 : 1237);
/*  803 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  809 */     _xdb_verify_unsafe_();
/*  810 */     StringBuilder _sb_ = new StringBuilder();
/*  811 */     _sb_.append("(");
/*  812 */     _sb_.append(this.peer);
/*  813 */     _sb_.append(",");
/*  814 */     _sb_.append(this.func);
/*  815 */     _sb_.append(",");
/*  816 */     _sb_.append(this.funcparm);
/*  817 */     _sb_.append(",");
/*  818 */     _sb_.append(this.algorithm);
/*  819 */     _sb_.append(",");
/*  820 */     _sb_.append("'").append(this.channel).append("'");
/*  821 */     _sb_.append(",");
/*  822 */     _sb_.append("'").append(this.registerchannel).append("'");
/*  823 */     _sb_.append(",");
/*  824 */     _sb_.append("'").append(this.gameappid).append("'");
/*  825 */     _sb_.append(",");
/*  826 */     _sb_.append(this.platid);
/*  827 */     _sb_.append(",");
/*  828 */     _sb_.append(this.telecomoper);
/*  829 */     _sb_.append(",");
/*  830 */     _sb_.append(this.jsonparams);
/*  831 */     _sb_.append(",");
/*  832 */     _sb_.append(this.fake_plat);
/*  833 */     _sb_.append(")");
/*  834 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  840 */     ListenableBean lb = new ListenableBean();
/*  841 */     lb.add(new ListenableChanged().setVarName("peer"));
/*  842 */     lb.add(new ListenableChanged().setVarName("func"));
/*  843 */     lb.add(new ListenableChanged().setVarName("funcparm"));
/*  844 */     lb.add(new ListenableChanged().setVarName("algorithm"));
/*  845 */     lb.add(new ListenableChanged().setVarName("channel"));
/*  846 */     lb.add(new ListenableChanged().setVarName("registerchannel"));
/*  847 */     lb.add(new ListenableChanged().setVarName("gameappid"));
/*  848 */     lb.add(new ListenableChanged().setVarName("platid"));
/*  849 */     lb.add(new ListenableChanged().setVarName("telecomoper"));
/*  850 */     lb.add(new xdb.logs.ListenableMap().setVarName("jsonparams"));
/*  851 */     lb.add(new ListenableChanged().setVarName("fake_plat"));
/*  852 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.OnlineUserInfo {
/*      */     private Const() {}
/*      */     
/*      */     OnlineUserInfo nThis() {
/*  859 */       return OnlineUserInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  865 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineUserInfo copy()
/*      */     {
/*  871 */       return OnlineUserInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineUserInfo toData()
/*      */     {
/*  877 */       return OnlineUserInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.OnlineUserInfo toBean()
/*      */     {
/*  882 */       return OnlineUserInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineUserInfo toDataIf()
/*      */     {
/*  888 */       return OnlineUserInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.OnlineUserInfo toBeanIf()
/*      */     {
/*  893 */       return OnlineUserInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPeer()
/*      */     {
/*  900 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  901 */       return OnlineUserInfo.this.peer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFunc()
/*      */     {
/*  908 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  909 */       return OnlineUserInfo.this.func;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFuncparm()
/*      */     {
/*  916 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  917 */       return OnlineUserInfo.this.funcparm;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAlgorithm()
/*      */     {
/*  924 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  925 */       return OnlineUserInfo.this.algorithm;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getChannel()
/*      */     {
/*  932 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  933 */       return OnlineUserInfo.this.channel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getChannelOctets()
/*      */     {
/*  940 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  941 */       return OnlineUserInfo.this.getChannelOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRegisterchannel()
/*      */     {
/*  948 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  949 */       return OnlineUserInfo.this.registerchannel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRegisterchannelOctets()
/*      */     {
/*  956 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  957 */       return OnlineUserInfo.this.getRegisterchannelOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getGameappid()
/*      */     {
/*  964 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  965 */       return OnlineUserInfo.this.gameappid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getGameappidOctets()
/*      */     {
/*  972 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  973 */       return OnlineUserInfo.this.getGameappidOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlatid()
/*      */     {
/*  980 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  981 */       return OnlineUserInfo.this.platid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTelecomoper()
/*      */     {
/*  988 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  989 */       return OnlineUserInfo.this.telecomoper;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<String, String> getJsonparams()
/*      */     {
/*  996 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*  997 */       return xdb.Consts.constMap(OnlineUserInfo.this.jsonparams);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<String, String> getJsonparamsAsData()
/*      */     {
/* 1004 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1006 */       OnlineUserInfo _o_ = OnlineUserInfo.this;
/* 1007 */       Map<String, String> jsonparams = new HashMap();
/* 1008 */       for (Map.Entry<String, String> _e_ : _o_.jsonparams.entrySet())
/* 1009 */         jsonparams.put(_e_.getKey(), _e_.getValue());
/* 1010 */       return jsonparams;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getFake_plat()
/*      */     {
/* 1017 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1018 */       return OnlineUserInfo.this.fake_plat;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeer(int _v_)
/*      */     {
/* 1025 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1026 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFunc(int _v_)
/*      */     {
/* 1033 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1034 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFuncparm(int _v_)
/*      */     {
/* 1041 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1042 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAlgorithm(int _v_)
/*      */     {
/* 1049 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1050 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChannel(String _v_)
/*      */     {
/* 1057 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1058 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChannelOctets(Octets _v_)
/*      */     {
/* 1065 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1066 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRegisterchannel(String _v_)
/*      */     {
/* 1073 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1074 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRegisterchannelOctets(Octets _v_)
/*      */     {
/* 1081 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1082 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGameappid(String _v_)
/*      */     {
/* 1089 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1090 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGameappidOctets(Octets _v_)
/*      */     {
/* 1097 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1098 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlatid(int _v_)
/*      */     {
/* 1105 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1106 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTelecomoper(int _v_)
/*      */     {
/* 1113 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1114 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFake_plat(boolean _v_)
/*      */     {
/* 1121 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1122 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/* 1128 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1129 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1135 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1136 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1142 */       return OnlineUserInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1148 */       return OnlineUserInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1154 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1155 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1161 */       return OnlineUserInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1167 */       return OnlineUserInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1173 */       OnlineUserInfo.this._xdb_verify_unsafe_();
/* 1174 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1180 */       return OnlineUserInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1186 */       return OnlineUserInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1192 */       return OnlineUserInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1198 */       return OnlineUserInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1204 */       return OnlineUserInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1210 */       return OnlineUserInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1216 */       return OnlineUserInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.OnlineUserInfo
/*      */   {
/*      */     private int peer;
/*      */     
/*      */     private int func;
/*      */     
/*      */     private int funcparm;
/*      */     
/*      */     private int algorithm;
/*      */     
/*      */     private String channel;
/*      */     
/*      */     private String registerchannel;
/*      */     
/*      */     private String gameappid;
/*      */     
/*      */     private int platid;
/*      */     
/*      */     private int telecomoper;
/*      */     
/*      */     private HashMap<String, String> jsonparams;
/*      */     
/*      */     private boolean fake_plat;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1248 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1253 */       this.channel = "";
/* 1254 */       this.registerchannel = "";
/* 1255 */       this.gameappid = "";
/* 1256 */       this.jsonparams = new HashMap();
/* 1257 */       this.fake_plat = false;
/*      */     }
/*      */     
/*      */     Data(xbean.OnlineUserInfo _o1_)
/*      */     {
/* 1262 */       if ((_o1_ instanceof OnlineUserInfo)) { assign((OnlineUserInfo)_o1_);
/* 1263 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1264 */       } else if ((_o1_ instanceof OnlineUserInfo.Const)) assign(((OnlineUserInfo.Const)_o1_).nThis()); else {
/* 1265 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(OnlineUserInfo _o_) {
/* 1270 */       this.peer = _o_.peer;
/* 1271 */       this.func = _o_.func;
/* 1272 */       this.funcparm = _o_.funcparm;
/* 1273 */       this.algorithm = _o_.algorithm;
/* 1274 */       this.channel = _o_.channel;
/* 1275 */       this.registerchannel = _o_.registerchannel;
/* 1276 */       this.gameappid = _o_.gameappid;
/* 1277 */       this.platid = _o_.platid;
/* 1278 */       this.telecomoper = _o_.telecomoper;
/* 1279 */       this.jsonparams = new HashMap();
/* 1280 */       for (Map.Entry<String, String> _e_ : _o_.jsonparams.entrySet())
/* 1281 */         this.jsonparams.put(_e_.getKey(), _e_.getValue());
/* 1282 */       this.fake_plat = _o_.fake_plat;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1287 */       this.peer = _o_.peer;
/* 1288 */       this.func = _o_.func;
/* 1289 */       this.funcparm = _o_.funcparm;
/* 1290 */       this.algorithm = _o_.algorithm;
/* 1291 */       this.channel = _o_.channel;
/* 1292 */       this.registerchannel = _o_.registerchannel;
/* 1293 */       this.gameappid = _o_.gameappid;
/* 1294 */       this.platid = _o_.platid;
/* 1295 */       this.telecomoper = _o_.telecomoper;
/* 1296 */       this.jsonparams = new HashMap();
/* 1297 */       for (Map.Entry<String, String> _e_ : _o_.jsonparams.entrySet())
/* 1298 */         this.jsonparams.put(_e_.getKey(), _e_.getValue());
/* 1299 */       this.fake_plat = _o_.fake_plat;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1305 */       _os_.marshal(this.peer);
/* 1306 */       _os_.marshal(this.func);
/* 1307 */       _os_.marshal(this.funcparm);
/* 1308 */       _os_.marshal(this.algorithm);
/* 1309 */       _os_.marshal(this.channel, "UTF-16LE");
/* 1310 */       _os_.marshal(this.registerchannel, "UTF-16LE");
/* 1311 */       _os_.marshal(this.gameappid, "UTF-16LE");
/* 1312 */       _os_.marshal(this.platid);
/* 1313 */       _os_.marshal(this.telecomoper);
/* 1314 */       _os_.compact_uint32(this.jsonparams.size());
/* 1315 */       for (Map.Entry<String, String> _e_ : this.jsonparams.entrySet())
/*      */       {
/* 1317 */         _os_.marshal((String)_e_.getKey(), "UTF-16LE");
/* 1318 */         _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */       }
/* 1320 */       _os_.marshal(this.fake_plat);
/* 1321 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1327 */       this.peer = _os_.unmarshal_int();
/* 1328 */       this.func = _os_.unmarshal_int();
/* 1329 */       this.funcparm = _os_.unmarshal_int();
/* 1330 */       this.algorithm = _os_.unmarshal_int();
/* 1331 */       this.channel = _os_.unmarshal_String("UTF-16LE");
/* 1332 */       this.registerchannel = _os_.unmarshal_String("UTF-16LE");
/* 1333 */       this.gameappid = _os_.unmarshal_String("UTF-16LE");
/* 1334 */       this.platid = _os_.unmarshal_int();
/* 1335 */       this.telecomoper = _os_.unmarshal_int();
/*      */       
/* 1337 */       int size = _os_.uncompact_uint32();
/* 1338 */       if (size >= 12)
/*      */       {
/* 1340 */         this.jsonparams = new HashMap(size * 2);
/*      */       }
/* 1342 */       for (; size > 0; size--)
/*      */       {
/* 1344 */         String _k_ = "";
/* 1345 */         _k_ = _os_.unmarshal_String("UTF-16LE");
/* 1346 */         String _v_ = "";
/* 1347 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 1348 */         this.jsonparams.put(_k_, _v_);
/*      */       }
/*      */       
/* 1351 */       this.fake_plat = _os_.unmarshal_boolean();
/* 1352 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1358 */       int _size_ = 0;
/* 1359 */       _size_ += CodedOutputStream.computeInt32Size(1, this.peer);
/* 1360 */       _size_ += CodedOutputStream.computeInt32Size(2, this.func);
/* 1361 */       _size_ += CodedOutputStream.computeInt32Size(3, this.funcparm);
/* 1362 */       _size_ += CodedOutputStream.computeInt32Size(4, this.algorithm);
/*      */       try
/*      */       {
/* 1365 */         _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(this.channel, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1369 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1373 */         _size_ += CodedOutputStream.computeBytesSize(6, ByteString.copyFrom(this.registerchannel, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1377 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1381 */         _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.gameappid, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1385 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1387 */       _size_ += CodedOutputStream.computeInt32Size(8, this.platid);
/* 1388 */       _size_ += CodedOutputStream.computeInt32Size(9, this.telecomoper);
/* 1389 */       for (Map.Entry<String, String> _e_ : this.jsonparams.entrySet())
/*      */       {
/*      */         try
/*      */         {
/* 1393 */           _size_ += CodedOutputStream.computeBytesSize(10, ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/*      */         }
/*      */         catch (UnsupportedEncodingException e)
/*      */         {
/* 1397 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */         try
/*      */         {
/* 1401 */           _size_ += CodedOutputStream.computeBytesSize(10, ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */         catch (UnsupportedEncodingException e)
/*      */         {
/* 1405 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/* 1408 */       _size_ += CodedOutputStream.computeBoolSize(11, this.fake_plat);
/* 1409 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1417 */         _output_.writeInt32(1, this.peer);
/* 1418 */         _output_.writeInt32(2, this.func);
/* 1419 */         _output_.writeInt32(3, this.funcparm);
/* 1420 */         _output_.writeInt32(4, this.algorithm);
/* 1421 */         _output_.writeBytes(5, ByteString.copyFrom(this.channel, "UTF-16LE"));
/* 1422 */         _output_.writeBytes(6, ByteString.copyFrom(this.registerchannel, "UTF-16LE"));
/* 1423 */         _output_.writeBytes(7, ByteString.copyFrom(this.gameappid, "UTF-16LE"));
/* 1424 */         _output_.writeInt32(8, this.platid);
/* 1425 */         _output_.writeInt32(9, this.telecomoper);
/* 1426 */         for (Map.Entry<String, String> _e_ : this.jsonparams.entrySet())
/*      */         {
/* 1428 */           _output_.writeBytes(10, ByteString.copyFrom((String)_e_.getKey(), "UTF-16LE"));
/* 1429 */           _output_.writeBytes(10, ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/* 1431 */         _output_.writeBool(11, this.fake_plat);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1435 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1437 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1445 */         boolean done = false;
/* 1446 */         while (!done)
/*      */         {
/* 1448 */           int tag = _input_.readTag();
/* 1449 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1453 */             done = true;
/* 1454 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1458 */             this.peer = _input_.readInt32();
/* 1459 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1463 */             this.func = _input_.readInt32();
/* 1464 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1468 */             this.funcparm = _input_.readInt32();
/* 1469 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1473 */             this.algorithm = _input_.readInt32();
/* 1474 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1478 */             this.channel = _input_.readBytes().toString("UTF-16LE");
/* 1479 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1483 */             this.registerchannel = _input_.readBytes().toString("UTF-16LE");
/* 1484 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1488 */             this.gameappid = _input_.readBytes().toString("UTF-16LE");
/* 1489 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1493 */             this.platid = _input_.readInt32();
/* 1494 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1498 */             this.telecomoper = _input_.readInt32();
/* 1499 */             break;
/*      */           
/*      */ 
/*      */           case 82: 
/* 1503 */             String _k_ = "";
/* 1504 */             _k_ = _input_.readBytes().toString("UTF-16LE");
/* 1505 */             int readTag = _input_.readTag();
/* 1506 */             if (82 != readTag)
/*      */             {
/* 1508 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1510 */             String _v_ = "";
/* 1511 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 1512 */             this.jsonparams.put(_k_, _v_);
/* 1513 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1517 */             this.fake_plat = _input_.readBool();
/* 1518 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1522 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1524 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1533 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1537 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1539 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineUserInfo copy()
/*      */     {
/* 1545 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineUserInfo toData()
/*      */     {
/* 1551 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.OnlineUserInfo toBean()
/*      */     {
/* 1556 */       return new OnlineUserInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OnlineUserInfo toDataIf()
/*      */     {
/* 1562 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.OnlineUserInfo toBeanIf()
/*      */     {
/* 1567 */       return new OnlineUserInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1577 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1581 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1585 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1589 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1593 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1597 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPeer()
/*      */     {
/* 1604 */       return this.peer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFunc()
/*      */     {
/* 1611 */       return this.func;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFuncparm()
/*      */     {
/* 1618 */       return this.funcparm;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAlgorithm()
/*      */     {
/* 1625 */       return this.algorithm;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getChannel()
/*      */     {
/* 1632 */       return this.channel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getChannelOctets()
/*      */     {
/* 1639 */       return Octets.wrap(getChannel(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRegisterchannel()
/*      */     {
/* 1646 */       return this.registerchannel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRegisterchannelOctets()
/*      */     {
/* 1653 */       return Octets.wrap(getRegisterchannel(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getGameappid()
/*      */     {
/* 1660 */       return this.gameappid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getGameappidOctets()
/*      */     {
/* 1667 */       return Octets.wrap(getGameappid(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlatid()
/*      */     {
/* 1674 */       return this.platid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTelecomoper()
/*      */     {
/* 1681 */       return this.telecomoper;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<String, String> getJsonparams()
/*      */     {
/* 1688 */       return this.jsonparams;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<String, String> getJsonparamsAsData()
/*      */     {
/* 1695 */       return this.jsonparams;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getFake_plat()
/*      */     {
/* 1702 */       return this.fake_plat;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeer(int _v_)
/*      */     {
/* 1709 */       this.peer = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFunc(int _v_)
/*      */     {
/* 1716 */       this.func = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFuncparm(int _v_)
/*      */     {
/* 1723 */       this.funcparm = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAlgorithm(int _v_)
/*      */     {
/* 1730 */       this.algorithm = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChannel(String _v_)
/*      */     {
/* 1737 */       if (null == _v_)
/* 1738 */         throw new NullPointerException();
/* 1739 */       this.channel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChannelOctets(Octets _v_)
/*      */     {
/* 1746 */       setChannel(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRegisterchannel(String _v_)
/*      */     {
/* 1753 */       if (null == _v_)
/* 1754 */         throw new NullPointerException();
/* 1755 */       this.registerchannel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRegisterchannelOctets(Octets _v_)
/*      */     {
/* 1762 */       setRegisterchannel(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGameappid(String _v_)
/*      */     {
/* 1769 */       if (null == _v_)
/* 1770 */         throw new NullPointerException();
/* 1771 */       this.gameappid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGameappidOctets(Octets _v_)
/*      */     {
/* 1778 */       setGameappid(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlatid(int _v_)
/*      */     {
/* 1785 */       this.platid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTelecomoper(int _v_)
/*      */     {
/* 1792 */       this.telecomoper = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFake_plat(boolean _v_)
/*      */     {
/* 1799 */       this.fake_plat = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1805 */       if (!(_o1_ instanceof Data)) return false;
/* 1806 */       Data _o_ = (Data)_o1_;
/* 1807 */       if (this.peer != _o_.peer) return false;
/* 1808 */       if (this.func != _o_.func) return false;
/* 1809 */       if (this.funcparm != _o_.funcparm) return false;
/* 1810 */       if (this.algorithm != _o_.algorithm) return false;
/* 1811 */       if (!this.channel.equals(_o_.channel)) return false;
/* 1812 */       if (!this.registerchannel.equals(_o_.registerchannel)) return false;
/* 1813 */       if (!this.gameappid.equals(_o_.gameappid)) return false;
/* 1814 */       if (this.platid != _o_.platid) return false;
/* 1815 */       if (this.telecomoper != _o_.telecomoper) return false;
/* 1816 */       if (!this.jsonparams.equals(_o_.jsonparams)) return false;
/* 1817 */       if (this.fake_plat != _o_.fake_plat) return false;
/* 1818 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1824 */       int _h_ = 0;
/* 1825 */       _h_ += this.peer;
/* 1826 */       _h_ += this.func;
/* 1827 */       _h_ += this.funcparm;
/* 1828 */       _h_ += this.algorithm;
/* 1829 */       _h_ += this.channel.hashCode();
/* 1830 */       _h_ += this.registerchannel.hashCode();
/* 1831 */       _h_ += this.gameappid.hashCode();
/* 1832 */       _h_ += this.platid;
/* 1833 */       _h_ += this.telecomoper;
/* 1834 */       _h_ += this.jsonparams.hashCode();
/* 1835 */       _h_ += (this.fake_plat ? 1231 : 1237);
/* 1836 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1842 */       StringBuilder _sb_ = new StringBuilder();
/* 1843 */       _sb_.append("(");
/* 1844 */       _sb_.append(this.peer);
/* 1845 */       _sb_.append(",");
/* 1846 */       _sb_.append(this.func);
/* 1847 */       _sb_.append(",");
/* 1848 */       _sb_.append(this.funcparm);
/* 1849 */       _sb_.append(",");
/* 1850 */       _sb_.append(this.algorithm);
/* 1851 */       _sb_.append(",");
/* 1852 */       _sb_.append("'").append(this.channel).append("'");
/* 1853 */       _sb_.append(",");
/* 1854 */       _sb_.append("'").append(this.registerchannel).append("'");
/* 1855 */       _sb_.append(",");
/* 1856 */       _sb_.append("'").append(this.gameappid).append("'");
/* 1857 */       _sb_.append(",");
/* 1858 */       _sb_.append(this.platid);
/* 1859 */       _sb_.append(",");
/* 1860 */       _sb_.append(this.telecomoper);
/* 1861 */       _sb_.append(",");
/* 1862 */       _sb_.append(this.jsonparams);
/* 1863 */       _sb_.append(",");
/* 1864 */       _sb_.append(this.fake_plat);
/* 1865 */       _sb_.append(")");
/* 1866 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\OnlineUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */